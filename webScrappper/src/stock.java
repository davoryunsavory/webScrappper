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

    public static String currentGeneral(String ticker, Document doc) {
        Element tablePriceTime = doc.select("table").get(0);
        Elements priceTime = tablePriceTime.select("tbody tr td.wsod_last span");
        String priceTimeText = priceTime.text();
        return priceTimeText;
    }

    public static String previousGeneral(String ticker, Document doc) {
        Element tablePreviousEndPrice = doc.select("table.wsod_dataTable.wsod_dataTableBig").get(0);
        Elements previousEndPrice = tablePreviousEndPrice.select("tbody tr:nth-of-type(1) td.wsod_quoteDataPoint");
        String previousEndPriceText = previousEndPrice.text();
        return previousEndPriceText;
    }

    public static double change(String ticker, Document doc) {
        Element tablePriceTime = doc.select("table").get(0);
        Elements priceTime = tablePriceTime.select("tbody tr td.wsod_last span");
        Element tablePreviousEndPrice = doc.select("table.wsod_dataTable.wsod_dataTableBig").get(0);
        Elements previousEndPrice = tablePreviousEndPrice.select("tbody tr:nth-of-type(1) td.wsod_quoteDataPoint");

        double currentPrice = Double.parseDouble(priceTime.text());
        double previousPrice = Double.parseDouble(previousEndPrice.text());
        double change = currentPrice - previousPrice;



        return change;
    }

    public static void main(String[] args) throws IOException {
        List<String> help = new ArrayList<String>();
        help.add("current");
        help.add("prev");
        help.add("diff");
        // System.in stock ticker
        Scanner s = new Scanner(System.in);
        System.out.println("INPUT STOCK TICKER: ");
        String ticker = s.nextLine();
        Document doc = Jsoup.connect("https://money.cnn.com/quote/quote.html?symb=" + ticker).get();
        System.out.println("INPUT COMMAND: ");
        String input = s.nextLine();
        s.close();
        for (int i = 0; i < 10; i++) {
            if (input.equals("current")) {
                System.out.println(currentGeneral(ticker, doc));
                break;
            } else if (input.equals("prev")) {
                System.out.println(previousGeneral(ticker, doc));
                break;
            } else if (input.equals("diff")) {
                System.out.println(change(ticker, doc));
                break;
            } else if (input.equals("help")) {
                System.out.println(help);
            }
        }
    }
}
