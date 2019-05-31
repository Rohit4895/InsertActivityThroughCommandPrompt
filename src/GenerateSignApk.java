import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class GenerateSignApk {

	private String pathToRun;
	private String keystoreFilePath;
	private String signedApkPath;
	private String keyStoreCredentials;
	private CallBacksForInsertActivity callBackSignedApk;

	public GenerateSignApk(String pathToRun, String keystoreFilePath, String signedApkPath, String keyStoreCredentials,
			CallBacksForInsertActivity callBackSignedApk) {
		this.pathToRun = pathToRun;
		this.keystoreFilePath = keystoreFilePath;
		this.signedApkPath = signedApkPath;
		this.keyStoreCredentials = keyStoreCredentials;
		this.callBackSignedApk = callBackSignedApk;
	}

	public int execute() throws IOException {

		Runtime rt = Runtime.getRuntime();

		String command = null;

		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if (osName.contains("window")) {
			command = "cmd /c cd " + pathToRun + " && apksigner sign --ks " + keystoreFilePath + " "
					+ keyStoreCredentials + " " + signedApkPath;
		} else if (osName.contains("mac")) {
			command = "./apksigner sign --ks/" + keystoreFilePath + " " + signedApkPath;
		} else {
			// Other systems
			command = "./apksigner sign --ks/" + keystoreFilePath + " " + signedApkPath;
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

		callBackSignedApk.signedApk(process.exitValue());

		return process.exitValue();
	}

}
