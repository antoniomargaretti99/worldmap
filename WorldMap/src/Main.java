import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

	
	public static void main(String[] args) {
				try {
					Map map = Map.load("map.csv");
					System.out.println("Misto: " + map.currentPositionName());
					map.goTo(0);
					System.out.println("Misto: " + map.currentPositionName());
					map.goTo(1);
					System.out.println("Misto: " + map.currentPositionName());
					map.goTo(3);
					System.out.println("Misto: " + map.currentPositionName());
					if(!map.goTo(4)) {
						System.out.println("not possible");
					}
					System.out.println("Misto: " + map.currentPositionName());
				} catch(FileNotFoundException e) {
					System.out.println("File with game map not found.");
				} catch (IOException ex) {
					System.out.println("There was a problem reading data from the file.");
				} catch (Exception ex) {
					System.out.println("The data in the file does not represent a world map.");
				}

	}

}
