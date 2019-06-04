package main_data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DemoAlterMenifest {

	private String menifestPath;
	private String splashActivityName, splashActivityPath;
	private List<Tag> allData;
	private CallBacksForInsertActivity callBackmanifest;

	public DemoAlterMenifest(String menifestPath, List<Tag> allData, CallBacksForInsertActivity callBackmanifest) {
		this.menifestPath = menifestPath;
		this.allData = allData;
		this.callBackmanifest = callBackmanifest;
	}

	/*
	 * 
	 * Step 1: Take list of All Category Nodes
	 * 
	 * Step 2: Find the Category Node with attribute as
	 * "android.intent.category.LAUNCHER"
	 * 
	 * Step 3: Get Parent activity of Node Category which has attribute
	 * "android.intent.category.LAUNCHER"
	 * 
	 */
	public void execute() throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(menifestPath);

		Node launcherActivityNode = getLauncherActivityNode(doc);
		splashActivityName = getSplashActivityName(launcherActivityNode);

		if (launcherActivityNode != null) {

			addNewActivityWithChildNodes(doc, launcherActivityNode);
			removeAllChilds(doc, launcherActivityNode);
			addNewIntentFilterToOldActivity(doc, launcherActivityNode);

			try {

				// create DOMSource for source XML document
				Source xmlSource = new DOMSource(doc);

				// create StreamResult for transformation result
				Result result = new StreamResult(new FileOutputStream(menifestPath));

				// create TransformerFactory
				TransformerFactory transformerFactory = TransformerFactory.newInstance();

				// create Transformer for transformation
				Transformer transformer = transformerFactory.newTransformer();

				transformer.setOutputProperty("indent", "yes");

				// transform and deliver content to client
				transformer.transform(xmlSource, result);

				callBackmanifest.manifestModification("success", splashActivityName, splashActivityPath);

			} catch (TransformerFactoryConfigurationError factoryError) {
				System.err.println("Error creating " + "TransformerFactory");
				factoryError.printStackTrace();
			} catch (TransformerException transformerError) {
				System.err.println("Error transforming document");
				transformerError.printStackTrace();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}

		}
	}

	private void removeAllChilds(Document doc, Node launcherActivityNode) {

		NodeList nodeList = launcherActivityNode.getChildNodes();
		System.out.println("Before launcherActivityNode ChildNodes: " + nodeList.getLength());
		for (int count = 0; count < launcherActivityNode.getChildNodes().getLength(); count++) {
			Node node = nodeList.item(count);
			System.out.println("getNodeName: " + node.getNodeName());
		}

		while (nodeList.getLength() > 0) {
			Node node = nodeList.item(0);
			node.getParentNode().removeChild(node);
		}
		launcherActivityNode.normalize();

		System.out
				.println("After launcherActivityNode ChildNodes: " + launcherActivityNode.getChildNodes().getLength());
		for (int count = 0; count < launcherActivityNode.getChildNodes().getLength(); count++) {
			Node node = nodeList.item(count);
			System.out.println("getNodeName: " + node.getNodeName());
		}

	}

	private void addNewActivityWithChildNodes(Document doc, Node launcherActivityNode) {

		Element newActivity = doc.createElement("activity");
		newActivity.setAttribute("android:name", "com.example.retrofitresponse.MainActivity");

		for (int count = 0; count < launcherActivityNode.getChildNodes().getLength(); count++) {
			Node cloneNode = launcherActivityNode.getChildNodes().item(count).cloneNode(true);
			newActivity.appendChild(cloneNode);
		}
		doc.adoptNode(newActivity);
		doc.getElementsByTagName("application").item(0).appendChild(newActivity);

	}

	private void addNewIntentFilterToOldActivity(Document doc, Node launcherActivityNode) {

		for (int i = 0; i < allData.size(); i++) {

			Tag tagsPojo = allData.get(i);
			Element element = doc.createElement(tagsPojo.getParentTag());
			if (tagsPojo.getListParentTagAttributes().size() > 0) {

				for (int j = 0; j < tagsPojo.getListParentTagAttributes().size(); j++) {

					Attributes attributes = tagsPojo.getListParentTagAttributes().get(j);
					element.setAttribute(attributes.getAttributeName(), attributes.getAttributeValue());

				}
			}

			System.out.println("sub tag size: " + tagsPojo.getSubTags().size());

			if (tagsPojo.getSubTags().size() > 0) {

				for (int j = 0; j < tagsPojo.getSubTags().size(); j++) {
					Tag subTags = tagsPojo.getSubTags().get(j);
					Element subTagElement = doc.createElement(subTags.getParentTag());
					System.out.println("sub tag: " + subTags.getParentTag());

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

			launcherActivityNode.appendChild(element);
		}

	}

	private Element getLauncherActivityNode(Document doc) {
		// Step 1
		NodeList launcher = doc.getElementsByTagName("category");

		for (int count = 0; count < launcher.getLength(); count++) {

			Element element = (Element) launcher.item(count);

			// Step 2
			if (element.getAttribute("android:name").equalsIgnoreCase("android.intent.category.LAUNCHER")) {

				// Step 3
				Element launcherActivityNode = (Element) element.getParentNode().getParentNode();
				System.out.println("launcherActivity Name: " + launcherActivityNode.getAttribute("android:name"));
				return launcherActivityNode;
			}

		}
		return null;
	}

	private String getSplashActivityName(Node launcherActivityNode) {

		splashActivityPath = ((Element) launcherActivityNode).getAttribute("android:name");

		String splashActivityName[] = splashActivityPath.split("\\.");

		return splashActivityName[(splashActivityName.length - 1)].trim() + ".smali";
	}
}
