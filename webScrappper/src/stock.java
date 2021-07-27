import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class stock {

    public static List<String> getStock(String ticker) throws IOException {
        // website connection
        Document doc = Jsoup.connect("https://money.cnn.com/quote/quote.html?symb=" + ticker).get();
        // html current price and time connection
        Element table = doc.select("table").get(0);
        Elements rows = table.select("tbody tr td.wsod_last span");
        // html previous end-day price connection
        Element find = doc.select("table.wsod_dataTable.wsod_dataTableBig").get(0);
        Elements outwards = find.select("tbody tr:nth-of-type(1) td.wsod_quoteDataPoint");
        // element to list conversion
        String[] current = new String[0];
        String[] currenttwo = new String[0];
        String rowsText = rows.text();
        String outwardsText = outwards.text();
        current = (rowsText.split(" "));
        currenttwo = (outwardsText.split(" "));
        List<String> currentList = new ArrayList<String>();
        Collections.addAll(currentList, current);
        Collections.addAll(currentList, currenttwo);

        return currentList;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("INPUT STOCK TICKER: ");
        String input = s.nextLine();
        System.out.println(getStock(input));
        s.close();
    }
}
