public class Rocket implements Spaceship {

	private int rocketCost;
	private int rocketWeight;
	private int maxRocketWeight;
	private int maxCargo;
	private int cargoWeight;
	private int totalWeight;
	
	private static int num_trials;
	
	public boolean launch(){
		return true;
	}
	
	public boolean land(){
		return true;
	}
	
	public void setRocketCost(int cost){
		rocketCost = cost;
	}
	
	public int getRocketCost(){
		return rocketCost;
	}
	
	public void setRocketWeight(int weight){
		rocketWeight = weight;
	}
	
	public void setMaxRocketWeight(int weight){
		maxRocketWeight = weight;
	}
	
	public int getMaxRocketWeight(){
		return maxRocketWeight;
	}
	
	public void setMaxCargo(){
		maxCargo = maxRocketWeight - rocketWeight;
	}
	
	public int getMaxCargo(){
		return maxCargo;
	}
	
	public void setCargoWeight(Item item){
		cargoWeight += item.getWeight();
	}
	
	public int getCargoWeight(){
		return cargoWeight;
	}

	public int getTotalWeight(){
		totalWeight = rocketWeight + getCargoWeight();
		return totalWeight;
	}
	

	public static void setNumberTrials(){
		num_trials++;
	}
	
	public static int getNumberTrials(){
		return num_trials;
	}
	
	public boolean canCarry(Item item){
		if(getCargoWeight() <= getMaxCargo() && getTotalWeight() <= getMaxRocketWeight()){
			return true;
		}
		else{
			System.out.println("Overloaded UOne Rocket");
			return false;
		}
	}
	
	public void carry(Item item){
		setCargoWeight(item);
	}
}
