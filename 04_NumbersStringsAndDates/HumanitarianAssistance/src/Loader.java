import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {
    public static void main(String[] args) throws IOException {

        final int CONTAINER_BOX_MAX = 27;
        final int TRUCK_CONTAINER_MAX = 12;

        int countContainer = 1;
        int countTruck = 1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int box = Integer.parseInt(reader.readLine());

        System.out.println("Truck " + countTruck + ":\n" + "Container " + countContainer +":");

        for (int i = 1; i < box; i++) {
            if (i % CONTAINER_BOX_MAX == 0) {

                if(countContainer >= TRUCK_CONTAINER_MAX ) {
                    countContainer = 1;
                    countTruck++;
                    System.out.println(i + "\nTruck " + countTruck + "\nContainer " + countContainer);
                    continue;
                }
                countContainer++;
                System.out.println(i + "\nContainer " + countContainer);

            } else {
                System.out.println(i);
            }
        }

    }
}
