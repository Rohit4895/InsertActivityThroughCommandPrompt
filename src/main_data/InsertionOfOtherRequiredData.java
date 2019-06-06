package main_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class InsertionOfOtherRequiredData {
	
	private Map<String, String> dataPaths;
	private String splashActivityPath;
	private String pathToSearch;
	private InsertActivityMainClass callbackInsertionOfData;
	
	public InsertionOfOtherRequiredData(Map<String, String> dataPaths, String splashActivityPath,
			String pathToSearch, InsertActivityMainClass callbackInsertionOfData) {
		this.dataPaths = dataPaths;
		this.splashActivityPath = splashActivityPath;
		this.pathToSearch = pathToSearch;
		this.callbackInsertionOfData = callbackInsertionOfData;
	}
	
	public void execute() {
		getCorrectFilePathOfMainActivity();
	}
	
	private void getCorrectFilePathOfMainActivity() {
		
		String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		
		String splashActivityName="";
		
		if(osName.contains("window")) {
			splashActivityName = splashActivityPath.substring(splashActivityPath.lastIndexOf("\\")+1, splashActivityPath.length());	
		}else {
			splashActivityName = splashActivityPath.substring(splashActivityPath.lastIndexOf("/")+1, splashActivityPath.length());
		}

		FileSearch fileSearch = new FileSearch();

		System.out.println("splash: "+splashActivityName);
		fileSearch.searchDirectory(new File(pathToSearch), splashActivityName+".smali");

		int count = fileSearch.getResult().size();
		if (count == 0) {
			System.out.println("\nNo result found!");
		} else {
			System.out.println("\nFound " + count + " result!\n");
			for (String matched : fileSearch.getResult()) {
				System.out.println("Path: from search: " + matched + " path from manifest: " + splashActivityPath);
				if (matched.contains(splashActivityPath)) {
					System.out.println("Right Path: "+matched);
					insertAllFiles(matched);
				} else {
					System.out.println("Wrong Path: ");
				}

			}

		}

	}
	
	private void insertAllFiles(String matchedFilePath) {
		String status = "success";

		for(Map.Entry<String, String> entry : dataPaths.entrySet()) {
			
			
			String srcPath = entry.getKey();
			String destPath = entry.getValue();
			File subject = new File(srcPath);
			
			if(subject.isFile() && destPath.equalsIgnoreCase("file")) {
				try {
				String matchedFilePathArray[] = null;
				String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
				
				if(osName.contains("window")) {
					matchedFilePathArray = matchedFilePath.split("\\\\");
				}else if(osName.contains("mac")){
					matchedFilePathArray = matchedFilePath.split("/");
				}else {
					matchedFilePathArray = matchedFilePath.split("/");
				}
				
				String pathToWriteFile = "";
				for (int j = 0; j < matchedFilePathArray.length - 1; j++) {
					
					pathToWriteFile += matchedFilePathArray[j] + "/";

				}

				if(osName.contains("window")) {
					pathToWriteFile += srcPath.substring(srcPath.lastIndexOf("\\")+1, srcPath.length());	
				}else {
					pathToWriteFile += srcPath.substring(srcPath.lastIndexOf("/")+1, srcPath.length());
				}
				
				File f1 = new File(srcPath);
				File f2 = new File(pathToWriteFile);
				String[] words = null;

				FileReader fr = new FileReader(f1);
				FileWriter fw = new FileWriter(f2);
				BufferedReader br = new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw);
				String s;
				while ((s = br.readLine()) != null) {
					
					bw.write(s + "\n");
				}

				br.close();
				bw.close();
			}catch (Exception e) {
				System.out.println("Error: "+e.getMessage());
			}
				
			}else if(subject.isDirectory()) {
				boolean fileExists = checkPathExists(destPath);
				
				if(!fileExists) {
					File theDir = new File(destPath);
					theDir.mkdir();
				}
				
				File srcDir = new File(srcPath);
				File destDir = new File(destPath);
				try {
					new FileUtils().copyDirectory(srcDir, destDir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					status = "fail";
					e.printStackTrace();
				}
				
				
			}
		}
		
		System.out.println("Done...");
		callbackInsertionOfData.insertionOfOtherRequiredDataCallback(status);
	}
	
	private static boolean checkPathExists(String checkPath) {

		Path path = Paths.get(checkPath);

		if (Files.exists(path)) {
			return true;
		}

		return false;
	}
}
