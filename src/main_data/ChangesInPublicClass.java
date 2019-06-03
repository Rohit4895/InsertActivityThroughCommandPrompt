package main_data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ChangesInPublicClass {

	private String filePath;
	private String pathToSearch;
	private String splashActivityName;
	private String splashActivityPath;
	private String replaceId;
	private Tag tagData;
	private String wrapperActivityName;
	private CallBacksForInsertActivity callBackInsertActivity;

	public ChangesInPublicClass(String filePath, Tag allData, String replaceId,
			String pathToSearch, String splashActivityName, String splashActivityPath, String wrapperActivityName,
			CallBacksForInsertActivity callBackInsertActivity) {
		this.filePath = filePath;
		this.tagData = allData;
		this.replaceId = replaceId;
		this.wrapperActivityName = wrapperActivityName;
		this.pathToSearch = pathToSearch;
		this.splashActivityName = splashActivityName;
		this.splashActivityPath = splashActivityPath;
		this.wrapperActivityName = wrapperActivityName;
		this.callBackInsertActivity = callBackInsertActivity;
	}

	public void execute() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filePath);

			Node mainParentNode = doc.getElementsByTagName("resources").item(0);

			NodeList tagList = doc.getElementsByTagName("public");
			int maxId = 0;

			Element newTag = doc.createElement(tagData.getParentTag());

			if (tagData.getListParentTagAttributes().size() > 0) {
				for (int i = 0; i < tagData.getListParentTagAttributes().size(); i++) {
					Attributes tagAttribute = tagData.getListParentTagAttributes().get(i);
					newTag.setAttribute(tagAttribute.getAttributeName(), tagAttribute.getAttributeValue());
				}
			}

			for (int i = 0; i < tagList.getLength(); i++) {
				Element element = (Element) tagList.item(i);
				String drawableAttribute = element.getAttribute("type");

				if (drawableAttribute.equals("drawable")) {

					String hex = element.getAttribute("id");
					int len = hex.length();

					if (Integer.parseInt(hex.substring(2, len), 16) > maxId)
						maxId = Integer.parseInt(hex.substring(2, len), 16);
				}
			}

			int id = maxId + 1;
			String newId = "0x" + Integer.toHexString(id);

			System.out.println("ids: " + maxId);

			newTag.setAttribute("id", newId);

			mainParentNode.appendChild(newTag);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(domSource, result);

			System.out.println("Done...");

			getCorrectFilePath(newId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getCorrectFilePath(String newId) {

		FileSearch fileSearch = new FileSearch();

		fileSearch.searchDirectory(new File(pathToSearch), splashActivityName);

		int count = fileSearch.getResult().size();
		if (count == 0) {
			System.out.println("\nNo result found!");
		} else {
			System.out.println("\nFound " + count + " result!\n");
			for (String matched : fileSearch.getResult()) {
				System.out.println("Path: from search: " + matched + " path from manifest: " + splashActivityPath);
				if (matched.contains(splashActivityPath)) {
					System.out.println("Right Path: ");
					addWrapperActivity(matched, newId);
				} else {
					System.out.println("Wrong Path: ");
				}

				// System.out.println("data : " + matched +" length:
				// "+fileSearch.getResult().size());
				// System.out.println("Found : " + fileSearch.getResult().get(0));

			}

		}

	}

	private void addWrapperActivity(String matchedPath, String newId) {
		try {
			
			String getRightPath[] = null;
			String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
			
			if(osName.contains("window")) {
				getRightPath = matchedPath.split("\\\\");
			}else if(osName.contains("mac")){
				getRightPath = matchedPath.split("/");
			}else {
				getRightPath = matchedPath.split("/");
			}
			
			String pathToWriteFile = "";
			for (int i = 0; i < getRightPath.length - 1; i++) {
				
				pathToWriteFile += getRightPath[i] + "/";

			}

			pathToWriteFile += wrapperActivityName;

			File f1 = new File(wrapperActivityName);
			File f2 = new File(pathToWriteFile);
			String[] words = null;

			FileReader fr = new FileReader(f1);
			FileWriter fw = new FileWriter(f2);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			String s;
			while ((s = br.readLine()) != null) {
				String line = "";
				words = s.split(" ");
				for (String word : words) {
					if (word.equals(replaceId)) {
						line += newId + " ";
					} else {
						line += word + " ";
					}
				}

				// System.out.println("S: " + s);
				// System.out.println("Line: " + line);

				bw.write(line + "\n");
			}

			br.close();
			bw.close();

			callBackInsertActivity.insertionOfWrapperActivity("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
