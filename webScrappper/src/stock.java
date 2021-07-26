import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;
import java.util.Collections;
import java.util.List;

public class stock {
    public static void main(String[] args) throws IOException {  
        Document doc = Jsoup.connect("https://money.cnn.com/quote/forecast/forecast.html?symb=GOOGL").get();

        Element table = doc.select("table").get(1);
        Elements rows = table.select("tbody tr td.wsod_last span");
        String temp;
        String[] threeMonth = new String[1];
        
        temp = rows.text();
        threeMonth = (temp.split(" "));
    
        List<String> tML = new ArrayList<String>();
        Collections.addAll(tML, threeMonth);
        System.out.println(tML);
        
        } 
}
