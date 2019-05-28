import java.io.File;
import java.util.List;

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

public class ChangesInPublicClass {

	private String filePath;
	private Tag tagData;

	public ChangesInPublicClass(String filePath, Tag allData) {
		this.filePath = filePath;
		this.tagData = allData;
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

				String hex = element.getAttribute("id");
				int len = hex.length();

				if (Integer.parseInt(hex.substring(2, len), 16) > maxId)
					maxId = Integer.parseInt(hex.substring(2, len), 16);
			}

			int id = maxId + 1;

			System.out.println("ids: " + maxId);

			newTag.setAttribute("id", "0x" + Integer.toHexString(id));

			mainParentNode.appendChild(newTag);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(domSource, result);

			System.out.println("Done...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
