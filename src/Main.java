import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpaceMission {

	public static void main(String[] args)  throws IOException {
		
		//Simulation object
		Simulation simulation = new Simulation();
		
		File phase1File = new File("Phase1.txt");
		File phase2File = new File("Phase2.txt");
		
		//Load item objects of Phase 1 and Phase 2 into ArrayLists
		ArrayList<Item> phase1Items = new ArrayList<Item>();
		ArrayList<Item> phase2Items = new ArrayList<Item>();
		
		System.out.println("Loading Phase 1 Items");
		System.out.print("---------------------");
		phase1Items = simulation.loadItems(phase1File);
		
		System.out.println("Loading Phase 2 Items");
		System.out.print("---------------------");
		phase2Items = simulation.loadItems(phase2File);
		
		//Load rockets of UOne and UTwo ArrayList
		ArrayList<Rocket> phase1UOneRockets = new ArrayList<Rocket>();
		ArrayList<Rocket> phase2UOneRockets = new ArrayList<Rocket>();
		
		System.out.println("\nLoading UOne rockets with Phase 1 Items");
		phase1UOneRockets = simulation.loadUOne(phase1Items);
		
		System.out.println("Loading UOne rockets with Phase 2 Items");
		phase2UOneRockets = simulation.loadUOne(phase2Items);
		
		//Load rockets of UOne and UTwo ArrayList
		ArrayList<Rocket> phase1UTwoRockets = new ArrayList<Rocket>();
		ArrayList<Rocket> phase2UTwoRockets = new ArrayList<Rocket>();
		
		System.out.println("Loading UTwo rockets with Phase 1 Items");
		phase1UTwoRockets = simulation.loadUTwo(phase1Items);
		
		System.out.println("Loading UTwo rockets with Phase 2 Items");
		phase2UTwoRockets = simulation.loadUTwo(phase2Items);
		
		System.out.println("Running simulation for UOne rockets");
		int trials = simulation.runSimulation(phase1UOneRockets);
		int trials2 = simulation.runSimulation(phase2UOneRockets);
		System.out.println("Total number of UOne Rockets used for the mission: " + (trials+trials2));
		System.out.println(" ");
		
		System.out.println("Running simulation for UTwo rockets");
		int trials3 = simulation.runSimulation(phase1UTwoRockets);
		int trials4 = simulation.runSimulation(phase2UTwoRockets);
		System.out.println("Total number of UTwo Rockets used for the mission: " + (trials3+trials4));
		System.out.println("");
		
		int UOne_trials = trials+trials2;
		int UTwo_trials = trials3+trials4;
		if(UOne_trials < UTwo_trials){
			System.out.println("UONE ROCKETS CHOSEN FOR THE MISSION");
		}
		else{
			System.out.println("UTWO ROCKETS CHOSEN FOR THE MISSION");
		}
	}
}


