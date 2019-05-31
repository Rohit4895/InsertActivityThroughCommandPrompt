import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class CompileModifiedApp {
	
	private CallBacksForInsertActivity callBackCompile;
	private String pathApkTool;
	private String folderToCompile;
	
	public CompileModifiedApp(String pathApkTool,
			String folderToCompile,
			CallBacksForInsertActivity callBackCompile) {
		this.pathApkTool = pathApkTool;
		this.folderToCompile = folderToCompile;
		this.callBackCompile = callBackCompile;
	}

public int execute() throws IOException {
		
		Runtime rt = Runtime.getRuntime();
		
		String command = null;
		
		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if(osName.contains("window")) {
			command = "cmd /c "+pathApkTool+" b "+folderToCompile;	
		}else if(osName.contains("mac")) {
			command = "java -jar "+pathApkTool+" b "+folderToCompile;
		}else {
			//Other systems
			command = "java -jar "+pathApkTool+" b "+folderToCompile;
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
			
		}
		
		Scanner scannerErr = new Scanner(process.getErrorStream(), "UTF-8");
		while(scannerErr.hasNext()) {
			System.out.println("Error: "+scannerErr.next());
		}
		
		callBackCompile.compileApk(process.exitValue());
		return process.exitValue();
	}
	
}
