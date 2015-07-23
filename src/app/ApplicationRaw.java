package app;

import disc.Context;
import disc.ContextualElement;
import disc.Standard;

public class ApplicationRaw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Standard celsiusStandard = new Standard();
		Standard humidityStandard = new Standard();
		
		celsiusStandard.setPrecision("0.2");
		celsiusStandard.setUnit("celsius");
		celsiusStandard.setRefreshRate("10s");
		
		humidityStandard.setPrecision("0.5");
		humidityStandard.setRefreshRate("30s");
		humidityStandard.setUnit("percentage");
		
		ContextualElement temperatureElement = new ContextualElement("temperature_id", "float", celsiusStandard);
		ContextualElement humidityElement = new ContextualElement("humidity_id", "float", humidityStandard);
		
		temperatureElement.requestRawResult();
		humidityElement.requestRawResult();
		
		Context fireContext = new Context();
		fireContext.setPermission("dummylevel2");
		fireContext.addElement(humidityElement);
		fireContext.addElement(temperatureElement);
		
		for(ContextualElement element: fireContext.getElements()){
			System.out.println("id="+element.getEntityId()+"\t\tvalue="+element.getResult());
		}
	}

}
