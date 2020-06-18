import org.apache.logging.log4j.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main
{
	private static Logger logger = LogManager.getLogger(Main.class);
	
    public static void main(String[] args) throws IOException {
    	  String srcFolder = args[0];
          String dstFolder = args[1];
          int newWidth = 300;
          File srcDir = new File(srcFolder);
          long start = System.currentTimeMillis();
          File[] files = srcDir.listFiles();
          List<Thread> threadList = new ArrayList<>();

          int numberCores = OSValidator.getNumberOfCPUCores();

          int partNumberCores = 0;
          int middle = files.length / numberCores;

          for (int i = 0; i < numberCores; i++) {

              File[] file = new File[files.length - (files.length - middle)];
              System.arraycopy(files, partNumberCores, file, 0, file.length);
              ImageResizer resizer = new ImageResizer(file, newWidth, dstFolder, start);
              threadList.add(new Thread((resizer)));
              threadList.get(i).start();
              partNumberCores += middle;
          }

          threadList.stream().filter(Thread::isAlive).forEach(o -> {
              try {
                  o.join();
              } catch (InterruptedException e) {
                  logger.error("thread ",e);
              }
          });
     
    }
}
