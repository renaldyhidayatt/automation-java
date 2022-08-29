import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebsiteGetTitle {
    public static void main(String args[]) throws IOException{
        Document doc = Jsoup.connect("http://h2020.myspecies.info").get();
        String varTitle = doc.title();
        String page = "https://en.wikipedia.org/wiki/Lists_of_countries_and_territories";

        System.out.println(varTitle);
    }
}
