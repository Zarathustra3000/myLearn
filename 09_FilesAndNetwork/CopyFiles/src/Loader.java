import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File derOne = new File(args[0]);
        File derTwo = new File(args[1]);
        Path p1 = Paths.get(derOne.getAbsolutePath());
        Path p2 = Paths.get(derTwo.getAbsolutePath());

        if (Files.exists(p2)) {
            System.out.println("This folder exists " + p2.getFileName().toString() +
                    ".\n" + "Delete it? y/n");
            String command = reader.readLine();
            if (command.equals("y") || command.equals("yes")) {
                Files.delete(p2);

                try {
                    Files.walkFileTree(p1, new MyFileVisitor(p1, p2));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (command.equals("n") || command.equals("no")){
                System.out.println("Sorry, files were not copied.");
            }
        }
        reader.close();

    }
}
