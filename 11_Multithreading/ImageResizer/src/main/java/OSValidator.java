import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSValidator {
	
	private static final String nameOS = System.getProperty("os.name").toLowerCase();
	//private int numberOfCPUCores = 0;
	static Integer i = 0;
	
	private static OSValidator instance;
	private OSValidator() {}
	public static OSValidator getInstance() {
		if(instance == null) {
			instance = new OSValidator();
		}
		return instance;
	}
	
	
	private static String command() throws IOException {
		String commands = "";
		BufferedReader reader = null;
		Process proc = null;
		if (nameOS.contains("mac")) {
			
			commands = "sysctl -n machdep.cpu.core_count";
			reader = getNumberOfCPUCores(commands);
			
			i = Integer.parseInt(reader.readLine());
			return commands;
			
		} else if (nameOS.contains("win")) {
			return "cmd /C WMIC CPU Get /Format:List";
		} else if (nameOS.contains("unix") || nameOS.contains("linux")) {
			return "nproc";
		} else {
			return null;
		}
	}
	private static BufferedReader getNumberOfCPUCores(String command) throws IOException {
		Process process = Runtime.getRuntime().exec(command);
		
		return new BufferedReader(new InputStreamReader(process.getInputStream()));
		
	}

  

}
