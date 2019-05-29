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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InsertActivityMainClass implements CallBacksForInsertActivity {

	private String splashActivityName;
	
	@Override
	public void decompile(int status) {
		System.out.println("Status: " + status+" on decompile");
		if (status == 1)
			return;

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

		//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\AndroidManifest.xml"
		
		String manifestPath = "C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars\\AndroidManifest.xml";
	    new AlterManifest(manifestPath, finalList, new InsertActivityMainClass()).execute();

	}

	@Override
	public void manifestModification(String status, String splashActivityName) {
		this.splashActivityName = splashActivityName;
		System.out.println("Status: " + status+" on manifestModification");
		if (status.isEmpty())
			return;
		
		// "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\RequiredData\\background.png",
		//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\res\\drawable\\background.png"

		new InsertImageDrawable("C:\\Users\\admin\\Desktop\\roh\\Mars\\RequiredData\\background.png",
				"C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars\\res\\drawable\\background.png", 
				new InsertActivityMainClass()).execute();

	}

	@Override
	public void insertionOfImage(String status) {
		System.out.println("Status: " + status+" on insertionOfImage");
		if (!status.equalsIgnoreCase("success"))
			return;

		Tag tagPublic = new Tag();
		tagPublic.setParentTag("public");
		tagPublic.add(new Attributes("type", "drawable"));
		tagPublic.add(new Attributes("name", "background"));

		String replaceId = "0x7f020093";
		
		/*
		 * String xmlPath =
		 * "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\res\\values\\public.xml";
		 * String activityPath =
		 * "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\RequiredData\\MainActivity.smali";
		 * String pathToSearch =
		 * "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia"; String fileName
		 * = "DA2Activity.smali";
		 */
		
		String xmlPath = "C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars\\res\\values\\public.xml";
		String activityPath = "C:\\Users\\admin\\Desktop\\roh\\Mars\\RequiredData\\MainActivity.smali";
		String pathToSearch = "C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars";
		String fileName = splashActivityName;
		String wrapperActivityName = "MainActivity.smali";

		new ChangesInPublicClass(xmlPath, tagPublic, replaceId, activityPath, pathToSearch, fileName,
				wrapperActivityName, new InsertActivityMainClass()).execute();

	}

	@Override
	public void insertionOfWrapperActivity(String status) {
		System.out.println("Status: " + status+" on insertionOfWrapperActivity");
		if (!status.equalsIgnoreCase("success"))
			return;
		int exitCode = 0;
		try {
			//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\apktool_2.4.0.jar",
			//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia"
			
			exitCode = new CompileModifiedApp("C:\\Users\\admin\\Desktop\\roh\\Mars\\apktool_2.4.0.jar",
					"C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars",
					new InsertActivityMainClass()).execute();
			System.out.println("ExitCode: " + exitCode);
		} catch (IOException e) {

			System.out.println("Error: " + e);
		}
	}

	@Override
	public void compileApk(int status) {
		System.out.println("Status: " + status+" on compileApk");
		if(status == 1)
			return;

		int exitCode1 = 0;
		try {
			
			//"C:\\Users\\admin\\AppData\\Local\\Android\\Sdk\\build-tools\\28.0.3",
			//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\dist\\Mini_Militia.apk",
			//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\dist\\Mini_Militia-align.apk"
			
			exitCode1 = new ZipAlignApk("C:\\Users\\admin\\AppData\\Local\\Android\\Sdk\\build-tools\\28.0.3",
					"C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars\\dist\\Mars_Mars.apk",
					"C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars\\dist\\Mars_Mars-align.apk",
					new InsertActivityMainClass())
							.execute();
			System.out.println("ExitCode: " + exitCode1);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}

	@Override
	public void zipAlign(int status) {
		System.out.println("Status: " + status+" on zipAlign");
		if (status == 1)
			return;

		String keyStoreCredentials = "--ks-key-alias marketplace --ks-pass pass:123456 --key-pass pass:123456";

		int exitCode2 = 0;
		try {
			
			//"C:\\Users\\admin\\AppData\\Local\\Android\\Sdk\\build-tools\\28.0.3",
			//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\RequiredData\\marketplace.jks",
			//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\dist\\Mini_Militia-align.apk"
			
			exitCode2 = new GenerateSignApk("C:\\Users\\admin\\AppData\\Local\\Android\\Sdk\\build-tools\\28.0.3",
					"C:\\Users\\admin\\Desktop\\roh\\Mars\\RequiredData\\marketplace.jks",
					"C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars\\dist\\Mars_Mars-align.apk",
					keyStoreCredentials,
					new InsertActivityMainClass()).execute();
			System.out.println("ExitCode: " + exitCode2);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

	@Override
	public void signedApk(int status) {
		System.out.println("Status: " + status+" on signedApk");
		int exitCode3 = 0;
		try {
			
			//"C:\\Users\\admin\\AppData\\Local\\Android\\Sdk\\platform-tools",
			//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\dist\\Mini_Militia-align.apk"
			
			exitCode3 = new InstallApk("C:\\Users\\admin\\AppData\\Local\\Android\\Sdk\\platform-tools",
					"C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars\\dist\\Mars_Mars-align.apk",
					new InsertActivityMainClass())
							.execute();
			System.out.println("ExitCode: " + exitCode3);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}

	@Override
	public void installedApk(int status) {
		System.out.println("Status: " + status+" on installedApk");
		if (status == 1)
			return;
		System.out.println("Activity inserted successfully...");

	}

	public static void main(String[] args) {
		
		//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\apktool_2.4.0.jar",
		//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia.apk",
		//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia"

		try {
			int exitStatus = new APKToolDecompile("C:\\Users\\admin\\Desktop\\roh\\Mars\\apktool_2.4.0.jar",
					"C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars.apk",
					"C:\\Users\\admin\\Desktop\\roh\\Mars\\Mars_Mars", new InsertActivityMainClass())
							.execute();

			System.out.println("ExitStatus: " + exitStatus);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
