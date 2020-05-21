import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Loader {
    public static void main(String[] args) throws IOException {

        Document html = Jsoup.connect("https://lenta.ru/")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();

        SearchAndDownloadImages.downloadImages(html, args[0]);
    }
}
