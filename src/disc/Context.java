package disc;

import java.util.ArrayList;
import java.util.List;

public class Context {

	private List<ContextualElement> elements;
	private String permission = null;
	
	public Context(){
		elements = new ArrayList<ContextualElement>();
		permission = "dummylowest";
	}

	public List<ContextualElement> getElements() {
		return elements;
	}

	public void setElements(List<ContextualElement> elements) {
		this.elements = elements;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public void addElement(ContextualElement element){
		elements.add(element);
	}
}
