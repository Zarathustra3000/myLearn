import java.io.File;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
    	  String srcFolder = args[0];
          String dstFolder = args[1];
          int newWidth = 300;
          File srcDir = new File(srcFolder);
          long start = System.currentTimeMillis();
          File[] files = srcDir.listFiles();

          int numberCores = OSValidator.getNumberOfCPUCores();

          if (numberCores <= 0) {
              System.out.println("Errors number of CPU cores");
          } else {
              int partNumberCores = 0;
              int middle = files.length / numberCores;

              for (int i = 0; i < numberCores; i++) {

                  File[] file = new File[files.length - (files.length - middle)];
                  System.arraycopy(files, partNumberCores, file, 0, file.length);
                  ImageResizer resizer = new ImageResizer(file, newWidth, dstFolder, start);
                  new Thread(resizer).start();
                  partNumberCores += middle;
              }
          }
     
    }
}
