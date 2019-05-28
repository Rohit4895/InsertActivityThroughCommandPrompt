import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InsertActivityMainClass {

	public static void main(String[] args) {
		/*
		 * try { Runtime rt = Runtime.getRuntime();
		 * 
		 * Process process = rt.
		 * exec("cmd /c C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\apktool_2.4.0.jar d C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia_4.2.8.apk -o C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia"
		 * ); Scanner scanner = new Scanner(process.getInputStream(), "UTF-8");
		 * while(scanner.hasNext()) { System.out.println(scanner.next()); }
		 * 
		 * Scanner scannerErr = new Scanner(process.getErrorStream(), "UTF-8");
		 * while(scannerErr.hasNext()) { System.out.println(scannerErr.next()); }
		 * 
		 * System.out.println("Exit Code: "+process.waitFor());
		 * 
		 * Process process1 =
		 * rt.exec("cmd /c apktool_2.4.0.jar d Mini_Militia_4.2.8.apk");
		 * System.out.println("Exit Code: "+process1.waitFor());
		 * 
		 * 
		 * 
		 * while(process.waitFor() != 0) {
		 * 
		 * } } catch (Exception e) { e.printStackTrace(); }
		 */

		/*
		 * try { new APKToolDecompile(
		 * "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\apktool_2.4.0.jar",
		 * "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia_4.2.8.apk",
		 * "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia") .execute(); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */

		// ==========================================================================================

		/*
		 * List<Tag> finalList = new ArrayList<Tag>();
		 * 
		 * Tag tagIntent = new Tag(); tagIntent.setParentTag("intent-filter");
		 * 
		 * Tag subTagAction = new Tag(); subTagAction.setParentTag("action");
		 * subTagAction.add(new Attributes("android:name", "com.custom.action"));
		 * tagIntent.addSubTags(subTagAction);
		 * 
		 * Tag subTagCategory = new Tag(); subTagCategory.setParentTag("category");
		 * subTagCategory.add(new Attributes("android:name",
		 * "android.intent.category.DEFAULT")); tagIntent.addSubTags(subTagCategory);
		 * 
		 * finalList.add(tagIntent);
		 * 
		 * String manifestPath =
		 * "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\AndroidManifest.xml";
		 * new AlterManifest(manifestPath, finalList).execute();
		 */

		// ===========================================================================================

		Tag tagPublic = new Tag();
		tagPublic.setParentTag("action");
		tagPublic.add(new Attributes("type", "drawable"));
		tagPublic.add(new Attributes("name", "backgroundImg"));

		new ChangesInPublicClass("C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\res\\values\\public.xml",
				tagPublic).execute();

	}

}
