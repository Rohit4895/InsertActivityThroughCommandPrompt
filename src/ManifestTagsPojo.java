import java.util.List;
import java.util.Map;

public class ManifestTagsPojo {

	private String childTag;
	private List<String> subChildTag;
	private Map<String, String> childAttributesAndValues;
	private List<Map<String, String>> subChildAttributesAndValues;
	
	public String getChildTag() {
		return childTag;
	}
	public void setChildTag(String childTag) {
		this.childTag = childTag;
	}
	public List<String> getSubChildTag() {
		return subChildTag;
	}
	public void setSubChildTag(List<String> subChildTag) {
		this.subChildTag = subChildTag;
	}
	public Map<String, String> getChildAttributesAndValues() {
		return childAttributesAndValues;
	}
	public void setChildAttributesAndValues(Map<String, String> childAttributesAndValues) {
		this.childAttributesAndValues = childAttributesAndValues;
	}
	public List<Map<String, String>> getSubChildAttributesAndValues() {
		return subChildAttributesAndValues;
	}
	public void setSubChildAttributesAndValues(List<Map<String, String>> subChildAttributesAndValues) {
		this.subChildAttributesAndValues = subChildAttributesAndValues;
	}
	
	
	
}
