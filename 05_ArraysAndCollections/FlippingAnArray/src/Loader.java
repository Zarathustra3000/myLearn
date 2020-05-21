import java.util.List;

public class Loader {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";

        String[] color = text.split(",?\\s+");
        String[] colorCopy = new String[color.length];

        for (int i = color.length - 1; i >= 0; i--) {
            int j = color.length - (i + 1);
            colorCopy[j] = color[i];
        }

        for (int i = 0; i < colorCopy.length; i++) {
            System.out.println(colorCopy[i]);
        }
    }
}
