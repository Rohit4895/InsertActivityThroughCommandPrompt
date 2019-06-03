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

	private static String apktoolJarPath;
	private static String decompileApkPath;
	private static String folderPathToStoreDecompileData;
	private static String manifestPath;
	private static String imageDrawableSourcePath;
	private static String imageDrawableDestinationPath;
	private static String replaceId;
	private static String xmlPath;
	private static String wrapperActivityPath;
	private static String pathToSearch;
	private static String fileName;
	private static String wrapperActivityName;
	private static String zipAlignSdkBuildToolPath;
	private static String compiledApkPath;
	private static String compiledAlignedApkPath;
	private static String signedSdkPlatformToolPath;
	private static String signedApkPath;
	private static String signSdkBuildToolPath;
	private static String keyStoreFilePath;
	private static String keyStoreCredentials;
	private static String splashActivityName;
	private static String splashActivityPath;
	private static String requiredDataPath;
	private static InsertActivityMainClass mainClass;

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

		// new AlterManifest(manifestPath, finalList, new
		// InsertActivityMainClass()).execute();

		try {
			new DemoAlterMenifest(manifestPath, finalList, mainClass).execute();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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

		new ChangesInPublicClass(xmlPath, tagPublic, replaceId, wrapperActivityPath, pathToSearch, splashActivityName,
				splashActivityPath, wrapperActivityName, mainClass).execute();

	}

	@Override
	public void insertionOfWrapperActivity(String status) {
		System.out.println("Status: " + status + " on insertionOfWrapperActivity");
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

	@Override
	public void takingDataFromUserCallBack() {

		System.out.println("Decompilation of APK is in progress...");

		try {
			int exitStatus = new APKToolDecompile(apktoolJarPath, decompileApkPath, folderPathToStoreDecompileData,
					mainClass).execute();

			System.out.println("ExitStatus: " + exitStatus);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		mainClass = new InsertActivityMainClass();
		getAllDataFromUser();

	}

	private static void getAllDataFromUser() {
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Enter APKTool Jar path: ");
//		apktoolJarPath = scanner.nextLine();
//		
//		System.out.println("Enter Decompile APK path: ");
//		decompileApkPath = scanner.nextLine();
//		
//		System.out.println("Enter Folder Path To Store Decompile Data: ");
//		folderPathToStoreDecompileData = scanner.nextLine();
//		
//		System.out.println("Enter Required Data Path: ");
//		requiredDataPath =  scanner.nextLine();
//		
//		System.out.println("Enter Image Destination Path: ");
//		imageDrawableDestinationPath = scanner.nextLine();
//		
//		System.out.println("Enter Resource Id To Replace:  ");
//		replaceId = scanner.nextLine();
//		
//		System.out.println("Enter Wrapper Activity Name: ");
//		wrapperActivityName = scanner.nextLine();
//		
//		System.out.println("Enter Zip Align SDK Build Tool Path: ");
//		zipAlignSdkBuildToolPath = scanner.nextLine();
//		
//		System.out.println("Enter SDK Platform Tool Path: ");
//		signedSdkPlatformToolPath = scanner.nextLine();
//		
//		System.out.println("Enter Keystore File Path: ");
//		keyStoreFilePath = scanner.nextLine();
//		
//		System.out.println("Enter KeyStore Credentials: ");
//		keyStoreCredentials = scanner.nextLine();

		/*
		 * apktoolJarPath =
		 * "/Users/apple/Desktop/MarketplaceApp/Tool/MiniMilitia/apktool_2.4.0.jar";
		 * decompileApkPath =
		 * "/Users/apple/Desktop/MarketplaceApp/Tool/MiniMilitia/MiniMilitia.apk";
		 * folderPathToStoreDecompileData =
		 * "/Users/apple/Desktop/MarketplaceApp/Tool/MiniMilitia/Mini_Militia";
		 * requiredDataPath =
		 * "/Users/apple/Desktop/MarketplaceApp/Tool/MiniMilitia/RequiredData";
		 * imageDrawableDestinationPath =
		 * "/Users/apple/Desktop/MarketplaceApp/Tool/MiniMilitia/Mini_Militia/res/drawable/background.png";
		 * replaceId= "0x7f020093"; wrapperActivityName = "MainActivity.smali";
		 * zipAlignSdkBuildToolPath =
		 * "/Users/apple/Library/Android/sdk/build-tools/28.0.3";
		 * signedSdkPlatformToolPath =
		 * "/Users/apple/Library/Android/sdk/platform-tools"; keyStoreFilePath =
		 * "/Users/apple/Desktop/MarketplaceApp/Tool/MiniMilitia/RequiredData/marketplace.jks";
		 * keyStoreCredentials =
		 * "--ks-key-alias marketplace --ks-pass pass:123456 --key-pass pass:123456";
		 */

		// Windows path
		apktoolJarPath = "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\apktool_2.4.0.jar";
		decompileApkPath = "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia.apk";
		folderPathToStoreDecompileData = "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia";
		requiredDataPath = "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\RequiredData";
		imageDrawableDestinationPath = "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\res\\drawable\\background.png";
		replaceId = "0x7f020093";
		wrapperActivityName = "MainActivity.smali";
		zipAlignSdkBuildToolPath = "C:\\Users\\admin\\AppData\\Local\\Android\\Sdk\\build-tools\\28.0.3";
		signedSdkPlatformToolPath = "C:\\Users\\admin\\AppData\\Local\\Android\\Sdk\\platform-tools";
		keyStoreFilePath = "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\RequiredData\\marketplace.jks";
		keyStoreCredentials = "--ks-key-alias marketplace --ks-pass pass:123456 --key-pass pass:123456";

		mainClass.takingDataFromUserCallBack();
	}

	private void assignValuesToRemainingString() {

		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if (osName.contains("window")) {
			manifestPath = folderPathToStoreDecompileData + "\\\\AndroidManifest.xml";
			imageDrawableSourcePath = requiredDataPath + "\\\\background.png";
			String apkName = decompileApkPath.substring((decompileApkPath.lastIndexOf("\\") + 1),
					decompileApkPath.length());
			compiledApkPath = folderPathToStoreDecompileData + "\\\\dist\\\\" + apkName;
			compiledAlignedApkPath = folderPathToStoreDecompileData + "\\\\dist\\\\" + "align-" + apkName;
		} else if (osName.contains("mac")) {
			manifestPath = folderPathToStoreDecompileData + "/AndroidManifest.xml";
			imageDrawableSourcePath = requiredDataPath + "/background.png";
			String apkName = decompileApkPath.substring((decompileApkPath.lastIndexOf("/") + 1),
					decompileApkPath.length());
			compiledApkPath = folderPathToStoreDecompileData + "/dist/" + apkName;
			compiledAlignedApkPath = folderPathToStoreDecompileData + "/dist/" + "align-" + apkName;
		} else {
			manifestPath = folderPathToStoreDecompileData + "/AndroidManifest.xml";
			imageDrawableSourcePath = requiredDataPath + "/background.png";
			String apkName = decompileApkPath.substring((decompileApkPath.lastIndexOf("/") + 1),
					decompileApkPath.length());
			compiledApkPath = folderPathToStoreDecompileData + "/dist/" + apkName;
			compiledAlignedApkPath = folderPathToStoreDecompileData + "/dist/" + "align-" + apkName;
		}

		FileSearch fileSearchPublicXml = new FileSearch();
		fileSearchPublicXml.searchDirectory(new File(folderPathToStoreDecompileData), "public.xml");
		xmlPath = fileSearchPublicXml.getResult().get(0);

		FileSearch fileSearchWrapperActivity = new FileSearch();
		fileSearchWrapperActivity.searchDirectory(new File(requiredDataPath), wrapperActivityName);
		wrapperActivityPath = fileSearchWrapperActivity.getResult().get(0);

		pathToSearch = folderPathToStoreDecompileData;

		signedApkPath = compiledAlignedApkPath;

		signSdkBuildToolPath = zipAlignSdkBuildToolPath;

		mainClass.assignedValuesToAllStringCallBack();
	}

}
