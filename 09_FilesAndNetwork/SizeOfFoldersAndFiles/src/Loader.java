import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Loader {

    private static final long SIZE_KB = 1024;
    private static Map<String, String> listNamesAndSize;

    public static void main(String[] args) {

        String way = args[0];

        File file = new File(way);

        if (file.exists()) {
            listNamesAndSize = conversionNameAndSize(file);
            printListNameAndSize(listNamesAndSize);
        } else {
            System.out.println("Путь не найден.");
        }
    }

    public static void printListNameAndSize(Map<String, String> map) {

        for (Map.Entry<String, String> pair: map.entrySet()) {
            System.out.printf("%-50.50s  %-50.50s%n", pair.getKey(), pair.getValue());
        }
    }

    private static Map<String, String> conversionNameAndSize(File nameFiles) {
        Map<String, String> mapNAS = new HashMap<>();

        for (File file: nameFiles.listFiles()) {
            if (file.isDirectory()) {
                mapNAS.put(file.getName(), sizeFile(sizeDirectory(file)));
            } else {
                mapNAS.put(file.getName(), sizeFile(file.length()));
            }
        }
        return mapNAS;
    }

    public static String sizeFile (Long sizeByte) {

        if (sizeByte / SIZE_KB > 0) {
            if (sizeByte / (SIZE_KB * SIZE_KB * SIZE_KB) >= 1) {
                return (sizeByte/(SIZE_KB * SIZE_KB * SIZE_KB)) + " GB";
            } else if(sizeByte/(SIZE_KB * SIZE_KB) >= 1) {
                return (sizeByte/(SIZE_KB * SIZE_KB)) + " MB";
            }
            return sizeByte/SIZE_KB + " KB";

        } else {
            return sizeByte + " Byte";
        }
    }

    public static Long sizeDirectory(File directory) {
        File[] listContent;
        Long size = 0L;

        if (directory.isDirectory()) {
            listContent = directory.listFiles();
            for (File file: listContent) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                   size += sizeDirectory(file);
                }
            }
        }
        return size;
    }

}