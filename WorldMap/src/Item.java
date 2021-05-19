
public class Item {
	protected String n;
	protected String desc;
	
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Item() {
		super();
	}
	
	public Item(String n, String desc) {
		super();
		this.n = n;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return  n + " - " + desc;
	}
	
	
	

}
