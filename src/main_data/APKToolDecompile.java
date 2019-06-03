package main_data;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class APKToolDecompile {

	private String pathApkTool;
	private String pathApk;
	private String pathToFolder;
	private CallBacksForInsertActivity callBackDecompile;

	public APKToolDecompile(String pathApkTool, String pathApk, String pathToFolder,
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
		System.out.println("OSName on Decompile: "+osName);
		
		
		if (osName.contains("window")) {
			command = "cmd /c " + pathApkTool + " d " + pathApk + " -o " + pathToFolder;
			System.out.println("In Window: pathApkTool: " + pathApkTool + " pathApk: " + pathApk + " pathToFolder: " + pathToFolder);
		} else if (osName.contains("mac")) {
			System.out.println("In Mac: pathApkTool: " + pathApkTool + " pathApk: " + pathApk + " pathToFolder: " + pathToFolder);
			command = "java -jar " + pathApkTool + " d " + pathApk + " -o " + pathToFolder;
		} else {
			System.out.println("In Else: pathApkTool: " + pathApkTool + " pathApk: " + pathApk + " pathToFolder: " + pathToFolder);
			command = "java -jar " + pathApkTool + " d " + pathApk + " -o " + pathToFolder;
		}

		System.out.println("=========== Decompile ==============");
		System.out.println(command);
		
		Process process;

		process = rt.exec(command);

		Scanner scanner = new Scanner(process.getInputStream(), "UTF-8");
		while (scanner.hasNext()) {
			System.out.println("InputStream: "+scanner.next());
		}

		Scanner scannerErr = new Scanner(process.getErrorStream(), "UTF-8");
		while (scannerErr.hasNext()) {
			System.out.println("Error: "+scannerErr.next());
		}

		callBackDecompile.decompile(process.exitValue());
		return process.exitValue();

	}

}
