import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class InstallApk {
	private String pathToRun;
	private String signedApkPath;
	private CallBacksForInsertActivity callBackInstallApk;
	
	public InstallApk(String pathToRun,
			String signedApkPath,
			CallBacksForInsertActivity callBackInstallApk) {
		this.pathToRun = pathToRun;
		this.signedApkPath = signedApkPath;
		this.callBackInstallApk = callBackInstallApk;
	}

	public int execute() throws IOException {
		
		Runtime rt = Runtime.getRuntime();
		
		String command = null;
		
		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if(osName.contains("window")) {
			command = "cmd /c cd "+pathToRun+" && adb install "+signedApkPath;	
		}else if(osName.contains("mac")) {
			
		}else {
			//Other systems
			
		}
		
		
		Process process;
		 
		process = rt.exec(command);
		
		BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { 
            	System.out.println("line is null.");break; }
            System.out.println("OutPut: "+line);
        }
		
		Scanner scanner = new Scanner(process.getInputStream(), "UTF-8");
		while(scanner.hasNext()) {
			 System.out.print("InputStream: "+scanner.next());
		}
		
		Scanner scannerErr = new Scanner(process.getErrorStream(), "UTF-8");
		while(scannerErr.hasNext()) {
			System.out.print("Error: "+scannerErr.next());
		}
		
		callBackInstallApk.installedApk(process.exitValue());
		return process.exitValue();
	}
}
