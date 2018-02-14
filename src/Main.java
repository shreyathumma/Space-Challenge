import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws IOException{
		
		U1 u1rocket = new U1();
		U2 u2rocket = new U2();
		
		//creating a Simulation object
		Simulation simulation = new Simulation();
		
		//to store Item objects in each phase
		ArrayList<Item> Phase1ArrayList = new ArrayList<Item>();
		ArrayList<Item> Phase2ArrayList = new ArrayList<Item>();
		
		//to store rocket objects for both U1 and U2 in each phase
		ArrayList<Rocket> U1_Phase1_ArrayList = new ArrayList<Rocket>();
		ArrayList<Rocket> U1_Phase2_ArrayList = new ArrayList<Rocket>();
		ArrayList<Rocket> U2_Phase1_ArrayList = new ArrayList<Rocket>();
		ArrayList<Rocket> U2_Phase2_ArrayList = new ArrayList<Rocket>();
		
		//to store number of trials in each phase for U1 and U2
		int U1Num_times, U1Num_times2, U2Num_times;
		int U2Num_times2;
		
		File Phase1_file = new File("C:/Users/shreya thumma/workspace/Space Challenge/Phase1.txt");
		File Phase2_file = new File("C:/Users/shreya thumma/workspace/Space Challenge/Phase2.txt");
		
		System.out.println("Loading items from Phase 1 and Phase 2 files");
		Phase1ArrayList = simulation.loadItems(Phase1_file);
		Phase2ArrayList = simulation.loadItems(Phase2_file);
		
		System.out.println("Loading U1 rockets with Phase 1 and Phase 2 Items");
		U1_Phase1_ArrayList = simulation.loadU1(Phase1ArrayList);
		U1_Phase2_ArrayList = simulation.loadU1(Phase2ArrayList);
		
		System.out.println("Running simulation for U1");
		U1Num_times = simulation.runSimulation(U1_Phase1_ArrayList);
		U1Num_times2 = simulation.runSimulation(U1_Phase2_ArrayList);
		int U1Total_trials = U1Num_times + U1Num_times2;
		
		U1.setNumberTrials(U1Total_trials);
		System.out.println("Total number of trials " + (U1Num_times + U1Num_times2));
		
	    int U1_totalCost = U1.getTotalCost();
	    System.out.println("U1 Total Cost " + U1_totalCost);
	    
	    U2Num_times = simulation.runSimulation(U2_Phase1_ArrayList);
	    System.out.println("Number of times U1 is launched and landed: " + U2Num_times);
		U2Num_times2 = simulation.runSimulation(U2_Phase2_ArrayList);
		System.out.println("Number of times U2 is launched and landed: " + U2Num_times2);
		
		int U2_totalCost = U2.getTotalCost();
	    System.out.println("U2 Total Cost " + U2_totalCost);
		
		
	}
}
