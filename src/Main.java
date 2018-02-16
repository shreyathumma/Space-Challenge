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
		ArrayList<Item> Phase1ItemArrayList = new ArrayList<Item>();
		ArrayList<Item> Phase2ItemArrayList = new ArrayList<Item>();
		
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
		Phase1ItemArrayList = simulation.loadItems(Phase1_file);
		Phase2ItemArrayList = simulation.loadItems(Phase2_file);
		
		System.out.println("Loading U1 rockets with Phase 1 and Phase 2 Items");
		U1_Phase1_ArrayList = simulation.loadU1(Phase1ItemArrayList);
		U1_Phase2_ArrayList = simulation.loadU1(Phase2ItemArrayList);
		
		System.out.println("Loading U2 rockets with Phase 1 and Phase 2 Items");
		U2_Phase1_ArrayList = simulation.loadU2(Phase1ItemArrayList);
		U2_Phase2_ArrayList = simulation.loadU2(Phase2ItemArrayList);
		
		System.out.println("Running simulation for U1");
		U1Num_times = simulation.runSimulation(U1_Phase1_ArrayList);
		U1Num_times2 = simulation.runSimulation(U1_Phase2_ArrayList);
		int U1Total_trials = U1Num_times + U1Num_times2;
		System.out.println("Total number of trials " + U1Total_trials);
		
		U1.setNumberTrials(U1Total_trials);
		
		
	    int U1_totalCost = U1.getTotalCost();
	    System.out.println("U1 Total Cost in millions" + U1_totalCost);
	    
	    System.out.println("Running simulation for U2");
	    U2Num_times = simulation.runSimulation(U2_Phase1_ArrayList);
		U2Num_times2 = simulation.runSimulation(U2_Phase2_ArrayList);
		int U2Total_trials = U2Num_times + U2Num_times2;
		System.out.println("Total number of trials " + U2Total_trials);
		
		U2.setNumberTrials(U2Total_trials);
		
		int U2_totalCost = U2.getTotalCost();
	    System.out.println("U2 Total Cost in millions " + U2_totalCost);
		
		
	}
}

