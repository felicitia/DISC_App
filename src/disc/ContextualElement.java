package disc;

import java.util.HashMap;
import java.util.Map;

import util.HttpUtil;

public class ContextualElement {

	private String entityId = null;
	private String dataType = null;
	private Standard standard = null;
	private String attr = null;
	private String result = null;
	
	public ContextualElement(String entityId, String dataType, Standard standard) {
		this.entityId = entityId;
		this.dataType = dataType;
		this.standard = standard;
	}
	
	public ContextualElement(String entityId, String attr){
		this.entityId = entityId;
		this.attr = attr;
	}

	public void requestRawResult(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", entityId);
		params.put("data_type", dataType);
		params.put("standard", standard.toJSON());
		this.result = HttpUtil.getResponseFromGET("http", "localhost:9000", "entityrawcontext", params);
	}
	
	public void requestResult(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", entityId);
		params.put("attr", attr);
		this.result = HttpUtil.getResponseFromGET("http", "localhost:9000", "entitycontext", params);
	}
	
	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
