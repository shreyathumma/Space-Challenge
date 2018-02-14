
public class Rocket implements Spaceship {

	private int rocketWeight;
	private int maxRocketWeight;
	private int maxCargo;
	private int currentWeight;
	private int totalCargoWeight;
	
	public boolean launch(){
		return true;
	}
	
	public boolean land(){
		return true;
	}
	
	public void setTotalCargoWeight(Item itemobject){
		totalCargoWeight += itemobject.getItemWeight();
	}
	
	public int getTotalCargoWeight(){
		return totalCargoWeight;
	}

	public void setCurrentWeight(Item itemobject){
		currentWeight = rocketWeight + itemobject.getItemWeight();
	}
	
	public int getCurrentWeight(){
		return currentWeight;
	}
	
	public boolean canCarry(Item itemobject){
		
		if(currentWeight <= maxRocketWeight){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void carry(Item itemobject){
		setCurrentWeight(itemobject);
		setTotalCargoWeight(itemobject);
	}
}
