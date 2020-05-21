public class Loader {
    public static void main(String[] args) {
        String[][] array = new String[7][7];

        String x = "x";
        int a = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j == 0 + a || j == (array.length-1) - a) {
                    array[i][j] = x;
                } else {
                    array[i][j] = " ";
                }
                System.out.print(array[i][j]);
            }
            System.out.println();
            a++;
        }
    }
}
