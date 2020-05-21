import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SearchAndDownloadImages {

    private static final String REGEX = "img[src~=(?i)\\.(png|jpe?g)]";

    public static void downloadImages(Document html, String directory) throws IOException {
        Elements elements = html.select(REGEX);

        for (Element element: elements) {
            String[] listNameAndExtension = nameImagesAndExtension(element);
            BufferedImage image = ImageIO.read(new URL(linkImages(element.toString())));

            ImageIO.write(image, listNameAndExtension[1], new File(directory + listNameAndExtension[0]));
            image.flush();
        }
    }

    private static String linkImages(String string) {
        return string.split("src=\"")[1].split("\"")[0];
    }

    private static String[] nameImagesAndExtension(Element element) {
        String name = linkImages(element.toString());
        name = name.substring(name.lastIndexOf("/")+1);
        return new  String[]{name, name.substring(name.lastIndexOf(".")+1)};
    }
}
