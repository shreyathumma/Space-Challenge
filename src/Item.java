
public class Item {

	private String itemName;
	private int itemWeight;
	
	Item(String name, int weight){
		itemName = name;
		itemWeight = weight;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public int getItemWeight(){
		return itemWeight;
	}
}
