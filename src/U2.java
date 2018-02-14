
public class U2 extends Rocket {

	private static final int ROCKETCOST_INMILLIONS = 120;
	private final int ROCKETWEIGHT = 18;
	private final int MAXCARGO = 11;
	private final int MAXROCKETWEIGHT = 29;

	private double launch_explosion;
	private double landing_crash;
	
	private static int num_trials;

	public boolean launch(){
		
		launch_explosion = 0.04 * ( getTotalCargoWeight()/ MAXCARGO);
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
		
		landing_crash = 0.08 * (getTotalCargoWeight() / MAXCARGO);
		double random_number = Math.random();
		if(landing_crash <= random_number){
			return true;
		}
		else{
			System.out.println("Crashed!!");
			return false;
		}
	}
	
	public boolean canCarry(Item itemobject){
		
		if(getCurrentWeight() <= MAXROCKETWEIGHT){
			return true;
		}
		else{
			System.out.println("Overload");
			return false;
		}
	}
	
	public void carry(Item itemobject){
		setCurrentWeight(itemobject);
		setTotalCargoWeight(itemobject);
	}
	
	public static int getNumberTrials(){
		return num_trials;
	}
	
	public static int getTotalCost(){
		return ROCKETCOST_INMILLIONS * getNumberTrials();
	}
	
}
