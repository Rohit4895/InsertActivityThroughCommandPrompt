import java.util.ArrayList;
import java.util.List;


public class Tag{
	
        private String tagName = null;
        private List<Attributes> tagAttributes = new ArrayList<>();
        private List<Tag> subTags = new ArrayList<>();
        
        public String getParentTag() {
            return tagName;
        }
        public void setParentTag(String parentTag) {
            this.tagName = parentTag;
        }
        public List<Attributes> getListParentTagAttributes() {
            return tagAttributes;
        }
        public void add(Attributes attribute) {
            this.tagAttributes.add(attribute);
        }
        public List<Tag> getSubTags() {
            return subTags;
        }
        public void addSubTags(Tag tag) {
            this.subTags.add(tag);
        }
        
    }
