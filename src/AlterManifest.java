import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AlterManifest {

	private String manifestPath;
	private NodeList activitySubNodes;
	private Element activityNode;
	private List<ManifestTagsPojo> allData;

	public AlterManifest(String manifestPath,List<ManifestTagsPojo> allData) {
		this.manifestPath = manifestPath;
		this.allData = allData;
	}

	public void execute() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(manifestPath);

			NodeList launcher = doc.getElementsByTagName("category");

			for (int i = 0; i < launcher.getLength(); i++) {
				Element element = (Element) launcher.item(i);
				System.out.println("Name: " + i + " "
						+ element.getAttribute("android:name").equalsIgnoreCase("android.intent.category.LAUNCHER"));

				if (element.getAttribute("android:name").equalsIgnoreCase("android.intent.category.LAUNCHER")) {
					System.out.println("Parent Node: " + element.getParentNode().getParentNode().getNodeName());
					activityNode = (Element) element.getParentNode().getParentNode();
					System.out.println("name: " + activityNode.getAttribute("android:name"));

					activitySubNodes = activityNode.getChildNodes();

					for (int j = 0; j < activityNode.getChildNodes().getLength(); j++) {
						System.out.println(" subChild: " + activityNode.getChildNodes().item(j).getNodeName());
						activityNode.removeChild(activityNode.getChildNodes().item(j));
					}
				}

			}

			Node application = doc.getElementsByTagName("application").item(0);

			Element activityWrapper = doc.createElement("activity");
			activityWrapper.setAttribute("android:name", "com.demo.MainActivity");
			for (int i = 0; i < activitySubNodes.getLength(); i++) {
				activityWrapper.appendChild(activitySubNodes.item(i));
			}

			application.appendChild(activityWrapper);
			
			for(int i=0 ; i<allData.size(); i++) {
				ManifestTagsPojo tagsPojo = allData.get(i);
				Element element = doc.createElement(tagsPojo.getChildTag());
				
				if(tagsPojo.getChildAttributesAndValues().size() > 0)
					for (Entry<String, String> entry : tagsPojo.getChildAttributesAndValues().entrySet() ) {
						element.setAttribute(entry.getKey(), entry.getValue());
					}
				
				if(tagsPojo.getSubChildTag().size() > 0)
					for(int j=0; j<tagsPojo.getSubChildTag().size(); j++) {
						String subChildTag = tagsPojo.getSubChildTag().get(j);
						Element tagElement = doc.createElement(subChildTag);
						
						if(tagsPojo.getSubChildAttributesAndValues().size() > 0)
							for(int k=0; k<tagsPojo.getSubChildAttributesAndValues().size(); k++) {
							Map<String, String> attriAndVal = tagsPojo.getSubChildAttributesAndValues().get(k);
							for (Entry<String, String> entry : attriAndVal.entrySet() ) {
								tagElement.setAttribute(entry.getKey(), entry.getValue());
							}
							}
						element.appendChild(tagElement);
					}
				activityNode.appendChild(element);
				
			}
			
			
			
			/*
			 * 
			 * action.setAttribute("android:name", "com.custom.action"); Element category =
			 * doc.createElement("category"); category.setAttribute("android:name",
			 * "android.intent.category.DEFAULT");
			 

			element.appendChild(action);
			element.appendChild(category);

			activityNode.appendChild(element);
*/
			//write to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(manifestPath));
			transformer.transform(domSource, result);

			System.out.println("Done...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
