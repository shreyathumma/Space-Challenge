

public class Rocket implements Spaceship {

	private int rocketWeight;
	private int maxRocketWeight;
	private int maxCargo;
	private int currentWeight;
	private int totalWeight;
	
	
	public boolean launch(){
		return true;
	}
	
	public boolean land(){
		return true;
	}
	
	
	public boolean canCarry(Item itemobject){
		
		if(currentWeight <= maxRocketWeight){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setCurrentWeight(Item itemobject){
		currentWeight += itemobject.getItemWeight();
	}
	
	public int getCurrentWeight(){
		return currentWeight;
	}

	public int getTotalWeight(){
		return totalWeight = rocketWeight + getCurrentWeight();
	}
	public void carry(Item itemobject){
		setCurrentWeight(itemobject);
	}
}
