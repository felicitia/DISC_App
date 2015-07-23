package app;

import disc.ContextualElement;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContextualElement userPosition = new ContextualElement("person1", "position");
		ContextualElement buildingTime = new ContextualElement("room1", "time");
		
		userPosition.requestResult();
		buildingTime.requestResult();
		
		if(userPosition.getResult().equals("lying")){
			System.out.println("id="+userPosition.getEntityId()+", result="+userPosition.getResult());
			System.out.println("lock phone's orientation");
		}
		
		if(buildingTime.getResult().equals("afterhour")){
			System.out.println("id="+buildingTime.getEntityId()+", result="+buildingTime.getResult());
			System.out.println("mute the phone");
		}
	}

}
