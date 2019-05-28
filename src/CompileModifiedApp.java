import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class CompileModifiedApp {
	
	private String pathApkTool;
	private String folderToCompile;
	
	public CompileModifiedApp(String pathApkTool,
			String pathToFolder) {
		this.pathApkTool = pathApkTool;
		this.folderToCompile = pathToFolder;
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
		
		//"cmd /c C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\apktool_2.4.0.jar d C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia_4.2.8.apk -o C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia"
		Process process;
		 
		process = rt.exec(command);
		System.out.println(process.getErrorStream().toString());
		BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = r.readLine()) != null) {
            
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
		
		return process.exitValue();
	}
	
}
