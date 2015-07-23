package disc;

import org.json.simple.JSONObject;

public class Standard{

	private String precision = null;
	private String refreshRate = null;
	private String unit = null;
	
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public String getRefreshRate() {
		return refreshRate;
	}
	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String toJSON(){
		JSONObject obj = new JSONObject();
		obj.put("precision", precision);
		obj.put("refreshRate", refreshRate);
		obj.put("unit", unit);
		return obj.toJSONString();
	}
}
