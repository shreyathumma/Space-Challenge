import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class Simulation {

	//Loads items from the file and returns an ArrayList of Item objects
	public ArrayList<Item> loadItems(File file) throws IOException{
		
		        //to read the file Phase1 
				FileReader filereader = new FileReader(file);
				BufferedReader bufferedreader = new BufferedReader(filereader);
				
				//to store the item name and weight read from file
				String item_name = null;
				int item_weight = 0;
				
				//After creating Item objects by passing item name and weight to Item constructor,
				//itemArrayList stores all the Item objects
				ArrayList <Item> Items = new ArrayList<Item>();
				
				//Reading the file while there are lines to read
				String line = null;
				
				while((line = bufferedreader.readLine()) != null){
					
					//splitting the line into two parts: before and after equals to(item name, weight)
					String[] splitByEquals = line.split("=");
					
				    for(String splitPart : splitByEquals){
				    	char check = splitPart.charAt(0);
				    	if(Character.isDigit(check)){
				    		item_weight = Integer.parseInt(splitPart);
				    	}
				    	else{
				    		item_name = splitPart;
				    	}
				    }
				    
					//Creating Item objects and adding them to the itemArrayList
				    Item item = new Item(item_name, item_weight);
					Items.add(item);
				}
				bufferedreader.close();	
				System.out.println(" LOADED");
				return Items; //returns the itemArrayList containing all Item objects
			}
	
	//Takes an ArrayList of Items and loads UOne Rocket with them
	public ArrayList<Rocket> loadUOne(ArrayList<Item> items){
		
		        //UOneRockets ArrayList stores all the UOne rocket objects after they are loaded
				ArrayList <Rocket> UOneRockets = new ArrayList<Rocket>();
				
				//Iterator to iterate through ArrayList of Items
				ListIterator <Item> iterator = items.listIterator();
				
				//Check if item is added to rocket
				boolean itemAdded[] = new boolean[items.size()]; //false by default
				//Check if all items are added
				boolean allItemsAdded = false;
				
				//Creating UOne object
				Rocket UOneRocket = new UOne();
				
				while(!allItemsAdded){
					while(iterator.hasNext()){
						Item item = iterator.next();
					
						if(UOneRocket.canCarry(item) && !itemAdded[items.indexOf(item)]){
							//System.out.println("Loading item " + (items.indexOf(item)+1));
							UOneRocket.carry(item);
							itemAdded[items.indexOf(item)] = true;
							//System.out.println(" ");
						}
						else{
							
							UOneRockets.add(UOneRocket);
							UOneRocket = new UOne();
							iterator = items.listIterator(items.indexOf(item));
						}
						
					}
					
				    for(boolean value : itemAdded){
				    	if(value == true){
				    		allItemsAdded = true;
				    	}
				    	else{
				    		allItemsAdded = false;
				    	}
				    	
				    }
				}
		     System.out.println("------------------ LOADED UONE ROCKETS");
		     System.out.println(" ");
		     return UOneRockets;
	}
	
	public ArrayList<Rocket> loadUTwo(ArrayList<Item> items){
		
        //UTwoRockets ArrayList stores all the UOne rocket objects after they are loaded
		ArrayList <Rocket> UTwoRockets = new ArrayList<Rocket>();
		
		//Iterator to iterate through ArrayList of Items
		ListIterator <Item> iterator = items.listIterator();
		
		//Check if item is added to rocket
		boolean itemAdded[] = new boolean[items.size()]; //false by default
		//Check if all items are added
		boolean allItemsAdded = false;
		
		//Creating UTwo object
		Rocket UTwoRocket = new UOne();
		
		while(!allItemsAdded){
			
			while(iterator.hasNext()){
				
				Item item = iterator.next();
				
				if(UTwoRocket.canCarry(item) && !itemAdded[items.indexOf(item)]){
					
					//System.out.println("Loading item " + (items.indexOf(item)+1));
					UTwoRocket.carry(item);
					itemAdded[items.indexOf(item)] = true;
					//System.out.println(" ");
				}
				else{
					
					UTwoRockets.add(UTwoRocket);
					UTwoRocket = new UOne();
					iterator = items.listIterator(items.indexOf(item));
				}
				
			}
		    for(boolean value : itemAdded){
		    	if(value == true){
		    		allItemsAdded = true;
		    	}
		    	else{
		    		allItemsAdded = false;
		    	}
		    	
		    }
		}

     System.out.println("---------------- LOADED UTWO ROCKETS");
     System.out.println(" ");
     return UTwoRockets;
	}
	
	public int runSimulation (ArrayList<Rocket> rockets){
		//calls launch and land for each rocket in the rockets array list
		
		for(Rocket rocket : rockets){
			if(rocket.launch()){
				//System.out.println("Successful launch!");
				Rocket.setNumberTrials();
			}
			else{
				while(!rocket.launch()){
					//System.out.println("Launching rocket again");
					rocket.launch();
					Rocket.setNumberTrials();
					if(rocket.launch()){
						//System.out.println("Successful launch!");
						break;
					}
			      }	
			}
			
			if(rocket.land()){
				//System.out.println("Successful land!");
			}
			while(!rocket.land()){
				//System.out.println("Launching rocket again");
				while(!rocket.launch()){
					//System.out.println("Launching rocket again");
					rocket.launch();
					Rocket.setNumberTrials();
					if(rocket.launch()){
						//System.out.println("Successful launch!");
						break;
					}
			}
				rocket.land();
				Rocket.setNumberTrials();
				if(rocket.land()){
					//System.out.println("Successful land!");
				}	
		}
	}
		//System.out.print("Total number of rockets used including the ones exploded/crashed: ");
		//System.out.println(Rocket.getNumberTrials());
		int trials = Rocket.getNumberTrials();
		return trials;
  }
}
