

public class U1 extends Rocket {
	
	private static final int ROCKETCOST_INMILLIONS = 100;
	private final int ROCKETWEIGHT = 10000;
	private final int MAXCARGO = 8000;
	private final int MAXROCKETWEIGHT = 18000;
	private int currentWeight;
	private int totalWeight;
	
	private double launch_explosion;
	private double landing_crash;
	
	private static int num_trials;

	public boolean launch(){
		
		launch_explosion = 0.05 * ( getCurrentWeight()/ MAXCARGO);
		double random_number = Math.random();
				if(launch_explosion <= random_number){
					return true;
				}
				else{
					System.out.println("Exploded!!");
					return false;
				}
	}
	
	public boolean land(){
		
		landing_crash = 0.01 * (getCurrentWeight() / MAXCARGO);
		double random_number = Math.random();
		if(landing_crash <= random_number){
			return true;
		}
		else{
			System.out.println("Crashed!!");
			return false;
		}
	}

	//Overrided method
	public int getTotalWeight(){
		return totalWeight = ROCKETWEIGHT + getCurrentWeight();
	}
	
	public boolean canCarry(Item itemobject){
		if(getCurrentWeight() <= MAXCARGO && getTotalWeight() <= MAXROCKETWEIGHT){
			return true;
		}
		else{
			System.out.println("Overloaded U1");
			return false;
		}
	}
	
	public void carry(Item itemobject){
		setCurrentWeight(itemobject);
	}
	
	public static void setNumberTrials(int trials){
		num_trials = trials;
	}
	
	public static int getNumberTrials(){
		return num_trials;
	}
	
	public static int getTotalCost(){
		return ROCKETCOST_INMILLIONS * getNumberTrials();
	}
}

