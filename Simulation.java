import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {

	//Method to load the items from the files
	public ArrayList<Item> loadItems(File fileobject) throws IOException{
		
		//to read the file Phase1 
		FileReader filereader = new FileReader(fileobject);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		
		//to store the item name and weight read from file
		String item_name = null;
		int item_weight = 0;
		
		//After creating Item objects by passing item name and weight to Item constructor,
		//itemArrayList stores all the Item objects
		ArrayList <Item> itemArrayList = new ArrayList<Item>(); //Generics
		
		//Reading the file while there are lines to read
		String line = null;
		while((line = bufferedreader.readLine()) != null){
			
			//splitting the line into two parts: before and after equalsto(item name, weight)
			String[] splitByEquals = line.split("=");
			
		    for(String splitPart : splitByEquals){
		    	char check = splitPart.charAt(0);
		    	if(Character.isDigit(check)){
		    		item_weight = Integer.parseInt(splitPart);
		    	}
		    	else{
		    		item_name = splitPart;
		    	}
			//Creating Item objects and adding them to the itemArrayList
		    Item itemObject_U1 = new Item(item_name, item_weight);
			itemArrayList.add(itemObject_U1);
		    } 
		}
		bufferedreader.close();	
		return itemArrayList; //returns the itemArrayList containing all Item objects
	}
	
	//Method to load the items to U1 rockets
	public ArrayList<Rocket> loadU1(ArrayList<Item> items){
		
		//U1ArrayList stores all the U1 rocket objects after they are loaded
		ArrayList <Rocket> U1ArrayList = new ArrayList<Rocket>();
		
		//Creating U1 object
		Rocket U1Rocket = new U1();
		while(items.size() != 0){
			
			for(Item itemobj : items){
				if(U1Rocket.canCarry(itemobj)){
					U1Rocket.carry(itemobj);
				}
				else{
					U1ArrayList.add(U1Rocket);
					U1Rocket = new U1();
					U1Rocket.carry(itemobj);
				}
		}
		}
		U1ArrayList.add(U1Rocket);
		System.out.println("U1 Loaded");
		return U1ArrayList;
		
	}
	
	//Method to load the items to U1 rockets
	public ArrayList<Rocket> loadU2(ArrayList<Item> items){
		
		//U2ArrayList stores all the U1 rocket objects after they are loaded
		ArrayList <Rocket> U2ArrayList = new ArrayList<Rocket>();
		
		Rocket U2Rocket = new U2();
		while(items.size() != 0){
			
			for(Item itemobj : items){
				if(U2Rocket.canCarry(itemobj)){
					U2Rocket.carry(itemobj);
				}
				else{
					U2ArrayList.add(U2Rocket);
					U2Rocket = new U2();
					U2Rocket.carry(itemobj);
				}
		}
		}
		U2ArrayList.add(U2Rocket);
		System.out.println("U2 Loaded");
		return U2ArrayList;
		
	}
	
	public int runSimulation(ArrayList<Rocket> rockets){

		int num_trials = 0;
		for(Rocket rocket : rockets){
			while(!rocket.launch()){
				System.out.println("Launching rocket");
				rocket.launch();
				num_trials++;
			}
			while(!rocket.land()){
				while(!rocket.launch()){
					System.out.println("Launching again");
					rocket.launch();
					num_trials++;
				}
				System.out.println("Landing rocket");
				rocket.land();
				num_trials++;
			}
		}
		return num_trials;
	}
	
	
}
