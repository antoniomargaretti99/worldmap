import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;


public class Map extends HashMap<Integer, Location> implements Serializable {
	private int start = 7; 
	private int currentPos = start;

	public static Map load(String fileName) throws IOException {
		Map m = new Map();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String row = "";
		while((row = reader.readLine())!=null) {
			String[] field = row.split(";");
			Location loc = new Location(field[1],Integer.parseInt(field[0]));
			for(int i = 0; i < 4; i++) {
				loc.connectLocation(i, Integer.parseInt(field[i+2]));
			}
			m.put(loc.getId(), loc);
		}
		reader.close();
		return m;
	}
	
	
	public String currentPositionName() {
		return this.get(currentPos).toString();
	}
	
	public boolean goTo(int dir) {
		int idKam = this.get(currentPos).getDir(dir);
		if(idKam == -1) {return false;}
		currentPos = idKam;
		return true;
	}

}
