import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;
import java.util.Collections;
import java.util.List;

public class bazaar {  
    public static void main(String[] args) throws IOException {  
        Document doc = Jsoup.connect("https://bazaartracker.com/product/enchanted_spruce_log").get();

        Element table = doc.select("svg").get(0);
        Elements rows = table.select("foreignObject");
        String temp;
        String[] threeMonth = new String[1];
        
        temp = rows.text().toString();
        threeMonth = (temp.split(" "));
    
        List<String> tML = new ArrayList<String>();
        Collections.addAll(tML, threeMonth);
        
        System.out.println(tML);
        }  
    }  