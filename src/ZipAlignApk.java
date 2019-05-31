import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class ZipAlignApk {

	private String pathToRun;
	private String compiledApkPath;
	private String newCompiledApkPath;
	private CallBacksForInsertActivity callBackZipAlign;

	public ZipAlignApk(String pathToRun, String compiledApkPath, String newCompiledApkPath,
			CallBacksForInsertActivity callBackZipAlign) {
		this.pathToRun = pathToRun;
		this.compiledApkPath = compiledApkPath;
		this.newCompiledApkPath = newCompiledApkPath;
		this.callBackZipAlign = callBackZipAlign;
	}

	public int execute() throws IOException {

		Runtime rt = Runtime.getRuntime();

		String command = null;

		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if (osName.contains("window")) {
			command = "cmd /c cd " + pathToRun + " && zipalign -p 4 " + compiledApkPath + " " + newCompiledApkPath;
		} else if (osName.contains("mac")) {
			command = "./zipalign -p 4/" + compiledApkPath + " " + newCompiledApkPath;
		} else {
			// Other systems
			command = "./zipalign -p 4/" + compiledApkPath + " " + newCompiledApkPath;
		}

		Process process;

		process = rt.exec(command);

		BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				System.out.println("line is null.");
				break;
			}
			System.out.println("OutPut: " + line);
		}

		Scanner scanner = new Scanner(process.getInputStream(), "UTF-8");
		while (scanner.hasNext()) {
			System.out.print("InputStream: " + scanner.next());
		}

		Scanner scannerErr = new Scanner(process.getErrorStream(), "UTF-8");
		while (scannerErr.hasNext()) {
			System.out.print("Error: " + scannerErr.next());
		}

		callBackZipAlign.zipAlign(process.exitValue());
		return process.exitValue();
	}

}
