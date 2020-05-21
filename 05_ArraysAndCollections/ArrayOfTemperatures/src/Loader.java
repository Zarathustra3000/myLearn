import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Loader {
    public static void main(String[] args) {

        double[] arrayTemperature = new double[30];

        for (int i = 0; i < arrayTemperature.length; i++) {
            arrayTemperature[i] = temperature();
        }

        System.out.println("Средняя температура: " + averageTemperature(arrayTemperature));
        System.out.println("Количество здоровых: " + healthyPatient(arrayTemperature));
        System.out.println("\nСписок температур пациентов:");

        for (int j = 0; j < arrayTemperature.length; j++) {
            System.out.println("Пациент " + (j + 1) + ", с температурой: " + arrayTemperature[j]);
        }

    }

    /*
    Метод "temperature()" - генерирующий случайную температуру пациента.
     */

    public static double temperature() {
        int min = 32;
        int max = 40;
        max -= min;
        double randomTemperature = ((Math.random() * ++max) + min);
        double ranTem = new BigDecimal(randomTemperature).setScale(1, RoundingMode.HALF_UP).doubleValue();

        return ranTem;
    }

    /*
    Метод "averageTemperature()" - расчитывает среднюю температуру.
    Сортирует список по возрастанию и возвращает число из середины списка.
     */

    public static double averageTemperature(double[] arrayTemperature) {

        for (int i = 0; i < arrayTemperature.length; i++) {
            for (int j = 0; j < arrayTemperature.length - 1; j++) {
                double n;
                if (arrayTemperature[j] > arrayTemperature[j + 1]){
                    n = arrayTemperature[j];
                    arrayTemperature[j] = arrayTemperature[j + 1];
                    arrayTemperature[j + 1] = n;
                }
            }
        }
        //Arrays.sort(arrayTemperature);
        return arrayTemperature[arrayTemperature.length/2];
    }

    /*
    Метод "healthyPatient()" - считает количество здоровых пациентов.
     */

    public static int healthyPatient(double[] arrayTemperature) {
        int count = 0;
        double minT = 36.2;
        double maxT = 36.9;

        for (int i = 0; i < arrayTemperature.length; i++) {
            if(arrayTemperature[i] > minT && arrayTemperature[i] < maxT ){
                count++;
            }
        }
        return count;
    }
}
