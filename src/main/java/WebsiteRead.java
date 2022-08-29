import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebsiteRead {
    public static void main(String args[]) throws IOException{
        String page = "https://en.wikipedia.org/wiki/Lists_of_countries_and_territories";
        Connection conn = Jsoup.connect(page);

        Document doc = conn.get();

        String result = doc.body().text();

        System.out.println(result);
    }
}
