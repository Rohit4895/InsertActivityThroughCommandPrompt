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
		
		
		
		
		List<String> subChildTags = new ArrayList<String>();
		subChildTags.add("action");
		subChildTags.add("category");
		
		Map<String, String> child = new HashMap<String, String>();
		
		List<Map<String, String>> listOfSubChildMap = new ArrayList<Map<String,String>>();
		listOfSubChildMap.add(getMap("android:name", "com.custom.action"));
		
		List<ManifestTagsPojo> finalList = new ArrayList<ManifestTagsPojo>();
		finalList.add(getAllData("intent-filter", child, subChildTags, listOfSubChildMap));
		
		
		
		
		String manifestPath = "C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Mini_Militia\\AndroidManifest.xml";
		new AlterManifest(manifestPath, finalList)
		.execute();

	}
	
	private static ManifestTagsPojo getAllData(String childTag, Map<String, String> child, List<String> subChildTags, List<Map<String, String>> listOfSubChildMap) {
		ManifestTagsPojo manifestTagsPojo = new ManifestTagsPojo();
		
		manifestTagsPojo.setChildTag(childTag);
		manifestTagsPojo.setChildAttributesAndValues(child);
		manifestTagsPojo.setSubChildTag(subChildTags);
		manifestTagsPojo.setSubChildAttributesAndValues(listOfSubChildMap);
		
		return manifestTagsPojo;
	}
	
	private static Map getMap(String key, String value) {
		Map<String, String> subChildAttributesAndValues = new HashMap<String, String>();
		subChildAttributesAndValues.put(key,value);
		return subChildAttributesAndValues;
	}

}
