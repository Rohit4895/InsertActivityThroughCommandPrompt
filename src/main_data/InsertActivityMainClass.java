package main_data;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class InsertActivityMainClass implements CallBacksForInsertActivity {

	private static String apktoolJarPath, pathOfApk, folderPathToStoreDecompileData, manifestPath,
			imageDrawableSourcePath, imageDrawableDestinationPath, replaceId, xmlPath, wrapperActivityPath,
			pathToSearch, fileName, wrapperActivityName, zipAlignSdkBuildToolPath, compiledApkPath,
			compiledAlignedApkPath, signedSdkPlatformToolPath, signedApkPath, signSdkBuildToolPath, keyStoreFilePath,
			keyStoreCredentials, splashActivityName, splashActivityPath, sdkPath;

	private static InsertActivityMainClass mainClass;

	private static void getAllDataFromUser() {

		Scanner scanner = new Scanner(System.in);

		keyStoreCredentials = "--ks-key-alias marketplace --ks-pass pass:123456 --key-pass pass:123456";

		System.out.println("Enter APK Path: ");
		pathOfApk = scanner.nextLine(); // "E:\\roh\\Mini_Militia.apk";

		System.out.println("Enter replaceId Path: ");
		replaceId = scanner.nextLine();// "0x7f020093";

		System.out.println("Enter SDK Path: ");
		sdkPath = scanner.nextLine(); // "C:\\Users\\admin\\AppData\\Local\\Android\\Sdk";

		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);

		if (osName.contains("window")) {
			System.out.println("In Window");
			apktoolJarPath = System.getProperty("user.dir") + "\\src\\tools\\apktool2.4.0.jar";// "E:\\roh\\apktool_2.4.0.jar";
			keyStoreFilePath = System.getProperty("user.dir") + "\\src\\tools\\marketplace.jks";
			imageDrawableSourcePath = System.getProperty("user.dir") + "\\src\\tools\\background.png";
			wrapperActivityName = System.getProperty("user.dir") + "\\src\\tools\\MainActivity.smali";
			int indexOfLastDot = pathOfApk.lastIndexOf(".");
			folderPathToStoreDecompileData = pathOfApk.substring(0, indexOfLastDot).trim();
			System.out.println("SubString: " + pathOfApk.substring(0, indexOfLastDot));
			imageDrawableDestinationPath = folderPathToStoreDecompileData + "\\res\\drawable\\background.png";
			zipAlignSdkBuildToolPath = sdkPath + "\\build-tools\\28.0.3";
			signedSdkPlatformToolPath = sdkPath + "\\platform-tools";

		} else if (osName.contains("mac")) {
			System.out.println("In Mac");
			apktoolJarPath = System.getProperty("user.dir") + "/src/tools/apktool2.4.0.jar";// "E:\\roh\\apktool_2.4.0.jar";
			keyStoreFilePath = System.getProperty("user.dir") + "/src/tools/marketplace.jks";
			imageDrawableSourcePath = System.getProperty("user.dir") + "/src/tools/background.png";
			wrapperActivityName = System.getProperty("user.dir") + "/src/tools/MainActivity.smali";
			int indexOfLastDot = pathOfApk.lastIndexOf(".");
			folderPathToStoreDecompileData = pathOfApk.substring(0, indexOfLastDot).trim();
			imageDrawableDestinationPath = folderPathToStoreDecompileData + "/res/drawable/background.png";
			zipAlignSdkBuildToolPath = sdkPath + "/build-tools/28.0.3";
			signedSdkPlatformToolPath = sdkPath + "/platform-tools";

		} else {
			System.out.println("In Else");
			apktoolJarPath = System.getProperty("user.dir") + "/src/tools/apktool2.4.0.jar";// "E:\\roh\\apktool_2.4.0.jar";
			keyStoreFilePath = System.getProperty("user.dir") + "/src/tools/marketplace.jks";
			imageDrawableSourcePath = System.getProperty("user.dir") + "/src/tools/background.png";
			wrapperActivityName = System.getProperty("user.dir") + "/src/tools/MainActivity.smali";
			int indexOfLastDot = pathOfApk.lastIndexOf(".");
			folderPathToStoreDecompileData = pathOfApk.substring(0, indexOfLastDot).trim();
			imageDrawableDestinationPath = folderPathToStoreDecompileData + "/res/drawable/background.png";
			zipAlignSdkBuildToolPath = sdkPath + "/build-tools/28.0.3";
			signedSdkPlatformToolPath = sdkPath + "/platform-tools";
		}
		System.out.println("Path to decompile: " + folderPathToStoreDecompileData);

		boolean fileExists = mainClass.checkPathExists(folderPathToStoreDecompileData);

		if (fileExists) {
			File theDir = new File(folderPathToStoreDecompileData);
			theDir.delete();
			System.out.println("File Exists");
		}
		mainClass.takingDataFromUserCallBack();
	}

	@Override
	public void takingDataFromUserCallBack() {

		System.out.println("Decompilation of APK is in progress...");
		System.out.println(" apktoolJarPath: " + apktoolJarPath + " pathOfApk: " + pathOfApk
				+ " folderPathToStoreDecompileData: " + folderPathToStoreDecompileData);

		try {
			int exitStatus = new APKToolDecompile(apktoolJarPath, pathOfApk, folderPathToStoreDecompileData, mainClass)
					.execute();

			System.out.println("ExitStatus: " + exitStatus);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void decompile(int status) {
		System.out.println("Status: " + status + " on decompile");
		if (status == 1)
			return;

		mainClass.assignValuesToRemainingString();

	}

	private void assignValuesToRemainingString() {

		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		System.out.println("OS Name: " + osName);
		if (osName.contains("window")) {
			manifestPath = folderPathToStoreDecompileData + "\\\\AndroidManifest.xml";
			String apkName = pathOfApk.substring((pathOfApk.lastIndexOf("\\") + 1), pathOfApk.length());
			compiledApkPath = folderPathToStoreDecompileData + "\\\\dist\\\\" + apkName;
			compiledAlignedApkPath = folderPathToStoreDecompileData + "\\\\dist\\\\" + "align-" + apkName;

		} else if (osName.contains("mac")) {

			manifestPath = folderPathToStoreDecompileData + "/AndroidManifest.xml";
			String apkName = pathOfApk.substring((pathOfApk.lastIndexOf("/") + 1), pathOfApk.length());
			compiledApkPath = folderPathToStoreDecompileData + "/dist/" + apkName;
			compiledAlignedApkPath = folderPathToStoreDecompileData + "/dist/" + "align-" + apkName;

		} else {

			manifestPath = folderPathToStoreDecompileData + "/AndroidManifest.xml";
			String apkName = pathOfApk.substring((pathOfApk.lastIndexOf("/") + 1), pathOfApk.length());
			compiledApkPath = folderPathToStoreDecompileData + "/dist/" + apkName;
			compiledAlignedApkPath = folderPathToStoreDecompileData + "/dist/" + "align-" + apkName;

		}

		FileSearch fileSearchPublicXml = new FileSearch();
		fileSearchPublicXml.searchDirectory(new File(folderPathToStoreDecompileData), "public.xml");
		xmlPath = fileSearchPublicXml.getResult().get(0);

		pathToSearch = folderPathToStoreDecompileData;

		signedApkPath = compiledAlignedApkPath;

		signSdkBuildToolPath = zipAlignSdkBuildToolPath;

		mainClass.assignedValuesToAllStringCallBack();
	}

	@Override
	public void assignedValuesToAllStringCallBack() {

		List<Tag> finalList = new ArrayList<Tag>();

		Tag tagIntent = new Tag();
		tagIntent.setParentTag("intent-filter");

		Tag subTagAction = new Tag();
		subTagAction.setParentTag("action");
		subTagAction.add(new Attributes("android:name", "com.custom.action"));
		tagIntent.addSubTags(subTagAction);

		Tag subTagCategory = new Tag();
		subTagCategory.setParentTag("category");
		subTagCategory.add(new Attributes("android:name", "android.intent.category.DEFAULT"));
		tagIntent.addSubTags(subTagCategory);

		finalList.add(tagIntent);

		try {
			new DemoAlterMenifest(manifestPath, finalList, mainClass).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void manifestModification(String status, String splashActivityName, String splashActivityPath) {

		this.splashActivityName = splashActivityName;

		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if (osName.contains("window")) {
			this.splashActivityPath = splashActivityPath.replaceAll("\\.", "\\\\");
		} else if (osName.contains("mac")) {
			this.splashActivityPath = splashActivityPath.replaceAll("\\.", "/");
		} else {
			this.splashActivityPath = splashActivityPath.replaceAll("\\.", "/");
		}

		System.out.println("Status: " + status + " on manifestModification Splash Name: " + this.splashActivityName);
		if (status.isEmpty())
			return;

		String checkPath = "";
		if (osName.contains("window")) {
			checkPath = imageDrawableDestinationPath.substring(0, imageDrawableDestinationPath.lastIndexOf("\\"));
		} else if (osName.contains("mac")) {
			checkPath = imageDrawableDestinationPath.substring(0, imageDrawableDestinationPath.lastIndexOf("/"));
		} else {
			checkPath = imageDrawableDestinationPath.substring(0, imageDrawableDestinationPath.lastIndexOf("/"));
		}

		boolean fileExists = checkPathExists(checkPath);

		if (fileExists) {
			new InsertImageDrawable(imageDrawableSourcePath, imageDrawableDestinationPath, mainClass).execute();
		} else {
			File theDir = new File(checkPath);

			try {
				theDir.mkdir();
				new InsertImageDrawable(imageDrawableSourcePath, imageDrawableDestinationPath, mainClass).execute();
			} catch (SecurityException se) {
				System.out.println("Error: " + se.getMessage());
			}
		}

	}

	private boolean checkPathExists(String checkPath) {

		Path path = Paths.get(checkPath);

		if (Files.exists(path)) {
			return true;
		}

		return false;
	}

	@Override
	public void insertionOfImage(String status) {
		System.out.println("Status: " + status + " on insertionOfImage");
		if (!status.equalsIgnoreCase("success"))
			return;

		Tag tagPublic = new Tag();
		tagPublic.setParentTag("public");
		tagPublic.add(new Attributes("type", "drawable"));
		tagPublic.add(new Attributes("name", "background"));

		new ChangesInPublicXmlAndInsertWrapperActivity(xmlPath, tagPublic, replaceId, 
				pathToSearch, splashActivityName, splashActivityPath,
				wrapperActivityName, mainClass).execute();

	}

	@Override
	public void insertionOfWrapperActivity(String status) {
		System.out.println("Status: " + status + " on insertionOfWrapperActivity");
		if (!status.equalsIgnoreCase("success"))
			return;
		int exitCode = 0;
		
		Map<String, String> dataPaths = new HashMap<String, String>();
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\MainActivity$1.smali", "file");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\MainActivity$2.smali", "file");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\Api.smali", "file");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\ApiInterface.smali", "file");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\Response.smali", "file");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\Subscription.smali", "file");
		
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\okhttp3",
				//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Manual\\smali\\okhttp3"
				"E:\\roh\\Clash_Of_Titans\\smali\\okhttp3");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\retrofit2",
				//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Manual\\smali\\retrofit2",
				"E:\\roh\\Clash_Of_Titans\\smali\\retrofit2");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\okio",
				//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Manual\\smali\\retrofit2",
				"E:\\roh\\Clash_Of_Titans\\smali\\okio");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\google",
				//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Manual\\smali\\com\\google",
				"E:\\roh\\Clash_Of_Titans\\smali\\com\\google");
		
		new InsertionOfOtherRequiredData(dataPaths, splashActivityPath, folderPathToStoreDecompileData, mainClass).execute();
		//try {

		//	exitCode = new CompileModifiedApp(apktoolJarPath, folderPathToStoreDecompileData, mainClass).execute();
		//	System.out.println("ExitCode: " + exitCode);
		//} catch (IOException e) {

		//	System.out.println("Error: " + e);
		//}
	}
	
	@Override
	public void insertionOfOtherRequiredDataCallback(String status) {
		System.out.println("Status: " + status + " on insertionOfOtherRequiredDataCallback");
		if (!status.equalsIgnoreCase("success"))
			return;
		int exitCode = 0;
		try {

			exitCode = new CompileModifiedApp(apktoolJarPath, folderPathToStoreDecompileData, mainClass).execute();
			System.out.println("ExitCode: " + exitCode);
		} catch (IOException e) {

			System.out.println("Error: " + e);
		}
		
	}

	@Override
	public void compileApk(int status) {
		System.out.println("Status: " + status + " on compileApk");
		if (status == 1)
			return;

		int exitCode1 = 0;
		try {

			exitCode1 = new ZipAlignApk(zipAlignSdkBuildToolPath, compiledApkPath, compiledAlignedApkPath, mainClass)
					.execute();
			System.out.println("compileApk ExitCode: " + exitCode1);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}

	@Override
	public void zipAlign(int status) {
		System.out.println("Status: " + status + " on zipAlign");
		if (status == 1)
			return;

		int exitCode2 = 0;
		try {

			exitCode2 = new GenerateSignApk(signSdkBuildToolPath, keyStoreFilePath, signedApkPath, keyStoreCredentials,
					mainClass).execute();
			System.out.println("ExitCode: " + exitCode2);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

	@Override
	public void signedApk(int status) {
		System.out.println("Status: " + status + " on signedApk");
		int exitCode3 = 0;
		try {

			exitCode3 = new InstallApk(signedSdkPlatformToolPath, signedApkPath, mainClass).execute();
			System.out.println("ExitCode: " + exitCode3);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}

	@Override
	public void installedApk(int status) {
		System.out.println("Status: " + status + " on installedApk");
		if (status == 1)
			return;
		System.out.println("Activity inserted successfully...");

	}

	public static void main(String[] args) {
		mainClass = new InsertActivityMainClass();
		getAllDataFromUser();

	}

}
