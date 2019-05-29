import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class APKToolDecompile {

	private String pathApkTool;
	private String pathApk;
	private String pathToFolder;
	private CallBacksForInsertActivity callBackDecompile;
	
	public APKToolDecompile(String pathApkTool,
			String pathApk,
			String pathToFolder,
			CallBacksForInsertActivity callBackDecompile) {
		this.pathApkTool = pathApkTool;
		this.pathApk = pathApk;
		this.pathToFolder = pathToFolder;
		this.callBackDecompile = callBackDecompile;
	}
	
	public int execute() throws IOException {
		
		Runtime rt = Runtime.getRuntime();
		
		String command = null;
		
		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if(osName.contains("window")) {
			command = "cmd /c "+pathApkTool+" d "+pathApk+" -o "+pathToFolder;	
		}else if(osName.contains("mac")) {
			command = "java -jar "+pathApkTool+" d "+pathApk+" -o "+pathToFolder;
		}else {
			//Other systems
			command = "java -jar "+pathApkTool+" d "+pathApk+" -o "+pathToFolder;
		}
		
		//"cmd /c C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\apktool_2.4.0.jar d C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia_4.2.8.apk -o C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia"
		Process process;
		 
		process = rt.exec(command);
		 
		Scanner scanner = new Scanner(process.getInputStream(), "UTF-8");
		while(scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		
		Scanner scannerErr = new Scanner(process.getErrorStream(), "UTF-8");
		while(scannerErr.hasNext()) {
			System.out.println(scannerErr.next());
		}
		
		callBackDecompile.decompile(process.exitValue());
		return process.exitValue();
		
	}
	
}
