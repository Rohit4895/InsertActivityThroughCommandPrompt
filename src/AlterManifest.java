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
	private List<Tag> allData;

	public AlterManifest(String manifestPath, List<Tag> allData) {
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

			for (int i = 0; i < allData.size(); i++) {

				Tag tagsPojo = allData.get(i);
				Element element = doc.createElement(tagsPojo.getParentTag());
				if (tagsPojo.getListParentTagAttributes().size() > 0) {

					for (int j = 0; j < tagsPojo.getListParentTagAttributes().size(); j++) {

						Attributes attributes = tagsPojo.getListParentTagAttributes().get(j);
						element.setAttribute(attributes.getAttributeName(), attributes.getAttributeValue());

					}
				}
					
					System.out.println("sub tag size: "+tagsPojo.getSubTags().size());

					if (tagsPojo.getSubTags().size() > 0) {

						for (int j = 0; j < tagsPojo.getSubTags().size(); j++) {
							Tag subTags = tagsPojo.getSubTags().get(j);
							Element subTagElement = doc.createElement(subTags.getParentTag());
							System.out.println("sub tag: "+subTags.getParentTag());

							if (subTags.getListParentTagAttributes().size() > 0) {

								for (int k = 0; k < subTags.getListParentTagAttributes().size(); k++) {

									Attributes subAttributes = subTags.getListParentTagAttributes().get(k);
									subTagElement.setAttribute(subAttributes.getAttributeName(),
											subAttributes.getAttributeValue());
									
								}
								
							}
							
							element.appendChild(subTagElement);
						}
					}

				activityNode.appendChild(element);
			}

			// write to file
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
