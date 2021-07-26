
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;
import java.util.Collections;
import java.util.List;
public class App {  
public static void main(String[] args) throws IOException {  
    Document doc = Jsoup.connect("https://markets.businessinsider.com/index/components/s&p_500?p=1").get();
    Element table = doc.select("table").get(0);
    Elements rows = table.select("tbody tr td.table__td:nth-of-type(6)");
    String temp;
    String[] threeMonth = new String[rows.size()];
    
    temp = rows.text().toString();
    threeMonth = (temp.split(" "));

    List<String> tML = new ArrayList<String>();
    Collections.addAll(tML, threeMonth);

    for (int i = 0; i < tML.size(); i++) {
        int pos = tML.indexOf(i); 
        if (pos % 2 == 0) {
            tML.remove(pos);
        }
    }
    
    System.out.println(tML);
    System.out.println("hello\\what");
    }  
}  