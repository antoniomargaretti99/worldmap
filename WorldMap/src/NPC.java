
public class NPC {
	
	protected String name;
	protected String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public NPC() {
		super();
	}
	
	public NPC(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	@Override
	public String toString() {
		return name + ": " + description;
	}
	
	

}
