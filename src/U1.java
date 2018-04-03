public class UOne extends Rocket {
	
	private double launch_explosion;
	private double landing_crash;
	
	private static int num_trials;

	//Constructor
	UOne(){
		setRocketCost(100);
		setRocketWeight(10000);
		setMaxRocketWeight(18000);
		setMaxCargo();
	}
	
	//Method to check if the rocket launched
	public boolean launch(){
		
		launch_explosion = 0.05 * (getCargoWeight()/ getMaxCargo());
		 double random_number = Math.random();
				if(launch_explosion <= random_number){
					return true;
				}
				else{
					System.out.println("Exploded!!");
					return false;
				}
	}
	
	//Method to check if rocket landed
	public boolean land(){
		
		landing_crash = 0.01 * (getCargoWeight() / getMaxCargo());
		double random_number = Math.random();
		if(landing_crash <= random_number){
			return true;
		}
		else{
			System.out.println("Crashed!!");
			return false;
		}
	}

	//Method to check if rocket can carry an Item
	public boolean canCarry(Item item){
		if(getCargoWeight() + getTotalWeight() <= getMaxRocketWeight()){
			return true;
		}
		else{
			System.out.println("Cannot carry next item");
			return false;
		}
	}
	
	//Method to load item into the Rocket and update cargo weight
	public void carry(Item item){
		setCargoWeight(item);
	}

	public static void setNumberTrials(){
		num_trials++;
	}
	
	public static int getNumberTrials(){
		return num_trials;
	}
	
	public int getTotalCost(){
		return getRocketCost() * getNumberTrials();
	}
}
