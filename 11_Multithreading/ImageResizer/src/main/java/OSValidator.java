import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSValidator {

    private static final String nameOS = System.getProperty("os.name").toLowerCase();

    private static OSValidator instance;
    private OSValidator() {}
    public static OSValidator getInstance() {
        if(instance == null) {
            instance = new OSValidator();
        }
        return instance;
    }

    public static int getNumberOfCPUCores() throws IOException {
        String commands;
        BufferedReader reader;

        if (nameOS.contains("mac")) {
            commands = "sysctl -n machdep.cpu.core_count";
            reader = getNumberOfCPUCoresCommand(commands);
            return Integer.parseInt(reader.readLine());

        } else if (nameOS.contains("win")) {
           commands = "cmd /C WMIC CPU Get /Format:List";
           reader = getNumberOfCPUCoresCommand(commands);
           return Integer.parseInt(reader.readLine().split("=")[1]);

        } else if (nameOS.contains("unix") || nameOS.contains("linux")) {
           commands = "nproc";
            reader = getNumberOfCPUCoresCommand(commands);
            return Integer.parseInt(reader.readLine());

        } else {
            return 0;
        }
    }

    private static BufferedReader getNumberOfCPUCoresCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);

        return new BufferedReader(new InputStreamReader(process.getInputStream()));

    }

}
