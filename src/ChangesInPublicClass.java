import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ChangesInPublicClass {

	private String filePath;
	private List<Tag> tagList;
	
	public ChangesInPublicClass(String filePath,List<Tag> tagList) {
		this.filePath = filePath;
		this.tagList = tagList;
	}
	
	public void execute() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filePath);
			
			Element mainParentNode = (Element) doc.getElementsByTagName("resources");
			
			NodeList tagList = doc.getElementsByTagName("public");
			int maxId = 0;
			
			for(int i=0; i<tagList.getLength(); i++) {
				Element element = (Element)tagList.item(i);
				
				String hex = element.getAttribute("id");
				int len = hex.length();
				
				if(Integer.parseInt(hex.substring(2,len), 16) > maxId)
					maxId = Integer.parseInt(hex.substring(2,len), 16);
			}
			
			System.out.println("ids: "+maxId);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
