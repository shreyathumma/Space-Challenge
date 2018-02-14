
public interface Spaceship {

	public boolean launch();
	
	public boolean land();
	
	public boolean canCarry (Item itemobject);
	
	public void carry(Item itemobject);
}