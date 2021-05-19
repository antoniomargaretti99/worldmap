import java.io.Serializable;
public class Location implements Serializable {
	
	

	private String name;
	private int id;
	private NPC npc;
	private Item item;
	
	int[] directions = new int[4]; 
	
	public Location(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public void connectLocation(int dir, int wh) {          
		directions[dir] = wh;
	}    
	
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	

	public int getDir(int dir) { 
		return directions[dir];
	}

	public NPC getNpc() {
		return npc;
	}

	public void setNpc(NPC npc) {
		this.npc = npc;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
