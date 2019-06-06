package main_data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tp {

	private String fileNameToSearch;
	private List<String> result = new ArrayList<String>();

	public String getFileNameToSearch() {
		return fileNameToSearch;
	}

	public void setFileNameToSearch(String fileNameToSearch) {
		this.fileNameToSearch = fileNameToSearch;
	}

	public List<String> getResult() {
		return result;
	}

	public void searchDirectory(File directory, String fileNameToSearch) {

		setFileNameToSearch(fileNameToSearch);

		if (directory.isDirectory()) {
			search(directory);
		} else {
			System.out.println(directory.getAbsoluteFile() + " is not a directory!");
		}

	}

	private void search(File file) {

		if (file.isDirectory()) {
			System.out.println("Searching directory ... " + file.getAbsoluteFile());

			// do you have permission to read this directory?
			if (file.canRead()) {
				for (File temp : file.listFiles()) {
					// System.out.println("Upper Temp: "+temp);
					if (temp.isDirectory()) {
						/*
						 * System.out.println(); System.out.println("temp: " + temp.getName());
						 * System.out.println();
						 */
						if (getFileNameToSearch().equals(temp.getName())) {
							result.add(temp.getAbsoluteFile().toString());
						} else {
							search(temp);
						}
					}
				}

			} else {
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			}
		}

	}

	
	public static void main(String[] args) {
	//new Tp().searchDirectory(new File("E:\\roh\\Clash_Of_Titans"), "gson");
		
		//splash : E:\roh\Clash_Of_Titans\smali\com\\unity3d\player
		
		// C:\Users\admin\eclipse-workspace\InsertActivityThroughCommandPrompt\src\tools\okhttp3
		//E:\roh\Clash_Of_Titans\smali
		
		// C:\Users\admin\eclipse-workspace\InsertActivityThroughCommandPrompt\src\tools\retrofit2
		// E:\roh\Clash_Of_Titans\smali
		
		// C:\Users\admin\eclipse-workspace\InsertActivityThroughCommandPrompt\src\tools\gson
		//E:\roh\Clash_Of_Titans\smali\com
		
		Map<String, String> dataPaths = new HashMap<String, String>();
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\MainActivity$1.smali", "file");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\MainActivity$2.smali", "file");
		
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\okhttp3",
				//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Manual\\smali\\okhttp3"
				"E:\\roh\\Clash_Of_Titans\\smali\\okhttp3");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\retrofit2",
				//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Manual\\smali\\retrofit2",
				"E:\\roh\\Clash_Of_Titans\\smali\\retrofit2");
		dataPaths.put("C:\\Users\\admin\\eclipse-workspace\\InsertActivityThroughCommandPrompt\\src\\tools\\google",
				//"C:\\Users\\admin\\Desktop\\roh\\MiniMilitia\\Manual\\smali\\com\\google",
				"E:\\roh\\Clash_Of_Titans\\smali\\com\\google");
		
		//new InsertionOfOtherRequiredData(dataPaths, "com\\unity3d\\player\\UnityPlayerActivity.smali",
		//		"E:\\roh\\Clash_Of_Titans").execute();
	}

}
