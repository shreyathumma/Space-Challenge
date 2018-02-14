
public class Item {

	private String itemName;
	private int itemWeight;
	
	Item(String name, int weight){
		itemName = name;
		itemWeight = weight;
	}
	
	public void setItemName(String iname){
		itemName = iname;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public void setItemWeight(int iweight){
		itemWeight = iweight;
	}
	
	public int getItemWeight(){
		return itemWeight;
	}
}
