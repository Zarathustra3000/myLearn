public class Loader {
    public static void main(String[] args) {
        String letters = "absdefghijklmnopqrstuvwxyzABSDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < letters.length(); i++) {
            int cod = (int) letters.charAt(i);
            System.out.println(letters.charAt(i) + " - " + cod);
        }
    }
}
