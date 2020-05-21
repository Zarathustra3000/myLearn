import java.util.*;

public class Loader {
    public static void main(String[] args) {

        List<String> listNumber = generationNumberOfTheCar();
        Collections.sort(listNumber);
        HashSet<String> hashNumber = new HashSet<>(listNumber);
        TreeSet<String> treeNumber = new TreeSet<>(listNumber);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input:");
            String number = scanner.next().trim();

            System.out.println(searchByBruteForce(listNumber,number));
            System.out.println(searchByBinary(listNumber,number));
            System.out.println(searchByHashSet(hashNumber,number));
            System.out.println(searchByTreeSet(treeNumber,number));
        }
    }

    public static List<String> generationNumberOfTheCar() {
        List<String> list = new ArrayList<>();
        List<String> letters = lettersOfNumber();
        List<String> number = numberOfTheCar();
        List<String> region = regionOfTheCar();

        for (int i = 0; i < region.size(); i++) {
            for (int j = 0; j < number.size(); j++) {
                for (int k = 0; k < letters.size(); k++) {
                    list.add(letters.get(k).substring(0,1) + number.get(j) + letters.get(k).substring(1,3) + region.get(i));
                }
            }
        }
        return list;
    }

    public static List<String> lettersOfNumber() {
        List<String> list = new ArrayList<>();

        // Тут латинские буквы.
        String[] letters = new String[]{"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                for (int k = 0; k < letters.length; k++) {
                    if (letters[i].equals(letters[j]) || letters[i].equals(letters[k]) || letters[j].equals(letters[k])) {
                        list.add(letters[i] + letters[j] + letters[k]);
                    }
                }
            }
        }
        return list;
    }

    public static List<String> numberOfTheCar() {

        return List.of("111", "222", "333", "444", "555", "666", "777", "888", "999");
    }

    public static List<String> regionOfTheCar() {
        List<String> list = new ArrayList<>();
        String[] numRegion = new String[132];
        String[] dopNumReg = new String[]{"102", "113", "116", "121", "123", "124", "125", "134", "136", "138",
                "142", "150", "152", "154", "159", "161", "163", "164", "169", "173",
                "174", "177", "178", "186", "190", "196", "197", "199", "725", "750",
                "777", "790", "797"};

        for (int i = 0; i < numRegion.length; i++) {
            numRegion[i] = String.valueOf(i + 1);
            if (i > 98) {
                numRegion[i] = dopNumReg[i - 99];
            }
        }

        for (int j = 0 ; j < numRegion.length; j++) {
            numRegion[j] = String.valueOf(j + 1);
            if (numRegion[j].length() == 1) {
                numRegion[j] = "0" + numRegion[j];
            }
            list.add(numRegion[j]);
        }
        return list;
    }

    public static String searchByBruteForce(List<String> list, String number) {

        long startContains = System.nanoTime();
        boolean b = list.contains(number);
        long stopContains = (System.nanoTime() - startContains);

        if (b){
            return "Поиск перебором: номер найден, поиск занял " + stopContains + "нс";
        } else {
            return "Поиск перебором: не найден, поиск занял " + stopContains + "нс";
        }
    }

    public static String searchByBinary(List<String> list, String number) {
        long startContains = System.nanoTime();
        int i = Collections.binarySearch(list, number);
        long stopContains = (System.nanoTime() - startContains);

        if (i > 0){
            return "Бинарный поиск: номер найден, поиск занял " + stopContains + "нс";
        } else {
            return "Бинарный поиск: не найден, поиск занял " + stopContains + "нс ";
        }
    }

    public static String searchByHashSet(HashSet<String> list, String number) {

        long startContains = System.nanoTime();
        boolean b = list.contains(number);
        long stopContains = (System.nanoTime() - startContains);

        if (b){
            return "Поиск в HashSet: номер найден, поиск занял " + stopContains + "нс";
        } else {
            return "Поиск в HashSet: номер не найден, поиск занял " + stopContains + "нс";
        }
    }

    public static String searchByTreeSet(TreeSet<String> list, String number) {

        long startContains = System.nanoTime();
        boolean b = list.contains(number);
        long stopContains = (System.nanoTime() - startContains);

        if (b){
            return "Поиск в TreeSet: номер найден, поиск занял " + stopContains + "нс";
        } else {
            return "Поиск в TreeSet: номер не найден, поиск занял " + stopContains + "нс";
        }
    }

}
