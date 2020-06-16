import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException {
//        String srcFolder = "/Users/aleksandr/Desktop/2";
//        String dstFolder = "/Users/aleksandr/Desktop/3";
//
//        File srcDir = new File(srcFolder);
//
//        long start = System.currentTimeMillis();
//
//        File[] files = srcDir.listFiles();
//
//        try
//        {
//            for(File file : files)
//            {
//                BufferedImage image = ImageIO.read(file);
//                if(image == null) {
//                    continue;
//                }
//
//                int newWidth = 300;
//                int newHeight = (int) Math.round(
//                        image.getHeight() / (image.getWidth() / (double) newWidth)
//                );
//                BufferedImage newImage = new BufferedImage(
//                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB
//                );
//
//                int widthStep = image.getWidth() / newWidth;
//                int heightStep = image.getHeight() / newHeight;
//
//                for (int x = 0; x < newWidth; x++)
//                {
//                    for (int y = 0; y < newHeight; y++) {
//                        int rgb = image.getRGB(x * widthStep, y * heightStep);
//                        newImage.setRGB(x, y, rgb);
//                    }
//                }
//
//                File newFile = new File(dstFolder + "/" + file.getName());
//                ImageIO.write(newImage, "jpg", newFile);
//            }
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("Duration: " + (System.currentTimeMillis() - start));
        OSValidator q = OSValidator.getInstance();
        System.out.println(q.getNumberOfCPUCores());
    }

//    public static int numberOfCPUCores() throws IOException {
//        String nameOS = System.getProperty("os.name").toLowerCase();
//        boolean s = nameOS.contains("mac");
//        String command = "sysctl -n machdep.cpu.core_count";
//        String[] cmd = { "/bin/sh", "-c", command};
//        Process process = Runtime.getRuntime().exec(cmd);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }
//
//        return 0;
//    }
}
