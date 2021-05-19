import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends JFrame{
	public static final int CANVAS_WIDTH = 700;
	public static final int CANVAS_HEIGHT = 400;
	public static final Color CANVAS_BG_COLOR = Color.WHITE;
	
	private String imgLocationFilename = "images\\";
	private Image imgLocation;
	private MapCanvas canvas;
	private JLabel title;
	
	private Map worldMap;

	public Game() {
		
		System.out.println("Inventory: ");
		ArrayList<Item> itemsarray = new ArrayList<>();
		
		NPC[] mobs = new NPC[10];
		
		NPC n1 = new NPC("Horse", "20HP, Neutral");
		mobs[0] = n1;
		NPC n2 = new NPC("Slug", "15HP, Hostile");
		mobs[1] = n2;
		NPC n3 = new NPC("Cow", "20HP, Neutral");
		mobs[2] = n3;
		NPC n4 = new NPC("Bee", "2HP, Passive");
		mobs[3] = n4;
		NPC n5 = new NPC("Raven", "8HP, Passive");
		mobs[4] = n5;
		NPC n6 = new NPC("Mad Butcher", "40HP, Hostile");
		mobs[5] = n6;
		NPC n7 = new NPC("Dog", "15HP, Tameable");
		mobs[6] = n7;
		NPC n8 = new NPC("Grim Reaper", "50HP, Passive");
		mobs[7] = n8;
		NPC n9 = new NPC("Piranha", "7HP, Passive");
		mobs[8] = n9;
		NPC n10 = new NPC("Traveller", "20HP, Neutral");
		mobs[9] = n10;
		
		Random rnd = new Random();
		
		Item[] items = new Item[10];
		
		Item i1 = new Item("Stick", "Just a stick");
		items[0] = i1;
		Item i2 = new Item("Sword", "Damage: 5, Durability: 200");
		items[1] = i2;
		Item i3 = new Item("Knife", "Damage: 4, Durability: 150");
		items[2] = i3;
		Item i4 = new Item("Bow", "Damage: 5, Durability: 150");
		items[3] = i4;
		Item i5 = new Item("Raw beef", "Hunger: 1.5");
		items[4] = i5;
		Item i6 = new Item("Methamphetamine", "Purity: 99.1%, Effects: Nausea 10s, Strength 40s, Speed 25s");
		items[5] = i6;
		Item i7 = new Item("Shield", "Protection: 5, Durability: 150");
		items[6] = i7;
		Item i8 = new Item("Book", "Adds +5 to intelligenceS");
		items[7] = i8;
		Item i9 = new Item("MG36", "Damage: 10, Durability: 1000, Reload time: 2s");
		items[8] = i9;
		Item i10 = new Item("Pistol", "Damage: 13, Durability: 300, Reload time: 5s");
		items[9] = i10;
		
		Random rnd2 = new Random();
		
		try {
			worldMap = Map.load("map.csv");
		}catch (IOException e) {
			System.out.println("Map is missing");
		}
		
	    try {
	    	String position = worldMap.currentPositionName().toLowerCase();
			imgLocation = ImageIO.read(new File(imgLocationFilename+position+".jpg"));
		} catch (IOException e) {
			System.out.println("Images missing");
		}
	    
	    JPanel mapPanel = new JPanel(new BorderLayout());
		
		JPanel northPanel = new JPanel(new BorderLayout());
		JPanel westPanel = new JPanel(new BorderLayout());
		JPanel eastPanel = new JPanel(new BorderLayout());
		JPanel southPanel = new JPanel(new BorderLayout());
		
		canvas = new MapCanvas();
	    canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	    
	    JButton btnNorth = new JButton("North");
	    northPanel.add(btnNorth,BorderLayout.CENTER);
	    btnNorth.addActionListener(new ActionListener() {
	       @Override
	       public void actionPerformed(ActionEvent evt) {
	    	   if(!worldMap.goTo(0)) {
	    		   JFrame frame = new JFrame("Info");
	    		   JOptionPane.showMessageDialog(frame, "You can't go north");
	    	   }
	    	   
	    	   try {
	   	    		String position = worldMap.currentPositionName().toLowerCase();
	   	    		imgLocation = ImageIO.read(new File(imgLocationFilename+position+".jpg"));
	   			} catch (IOException e) {
	   				System.out.println("Images missing");
	   			}
	    		int rn = rnd.nextInt(10);
	    		int rn2 = rnd2.nextInt(10);
	    	   canvas.repaint();
	    	   title.setText(worldMap.currentPositionName() + ". Mobs: " + mobs[rn] + ", " + "Items: " + items[rn2]);
	    	   
	    itemsarray.add(items[rn2]);
	    System.out.println(items[rn2]);
	    
	    	   
	         
	       }
	    });
	    
	    JButton btnWest = new JButton("West");
	    westPanel.add(btnWest,BorderLayout.CENTER);
	    btnWest.addActionListener(new ActionListener() {
	       @Override
	       public void actionPerformed(ActionEvent evt) {
	    	   if(!worldMap.goTo(3)) {
	    		   JFrame frame = new JFrame("Info");
	    		   JOptionPane.showMessageDialog(frame, "You can't go west");
	    	   }
	          
	          try {
	   	    		String position = worldMap.currentPositionName().toLowerCase();
	   	    		imgLocation = ImageIO.read(new File(imgLocationFilename+position+".jpg"));
	   			} catch (IOException e) {
	   				System.out.println("Images missing");
	   			}
	          int rn = rnd.nextInt(10);
	    		int rn2 = rnd2.nextInt(10);
	    	   canvas.repaint();
	    	   title.setText(worldMap.currentPositionName() + ". Mobs: " + mobs[rn] + ", " + "Items: " + items[rn2]);
	    	   itemsarray.add(items[rn2]);
	   	    System.out.println(items[rn2]);
	       }
	    });
	    
	    JButton btnEast = new JButton("East");
	    eastPanel.add(btnEast,BorderLayout.CENTER);
	    btnEast.addActionListener(new ActionListener() {
	       @Override
	       public void actionPerformed(ActionEvent evt) {
	    	   if(!worldMap.goTo(1)) {
	    		   JFrame frame = new JFrame("Info");
	    		   JOptionPane.showMessageDialog(frame, "You can't go east");
	    	   }
	         
	         try {
	   	    		String position = worldMap.currentPositionName().toLowerCase();
	   	    		imgLocation = ImageIO.read(new File(imgLocationFilename+position+".jpg"));
	   			} catch (IOException e) {
	   				System.out.println("Images missing");
	   			}
	         int rn = rnd.nextInt(10);
	    		int rn2 = rnd2.nextInt(10);
	    	   canvas.repaint();
	    	   title.setText(worldMap.currentPositionName() + ". Mobs: " + mobs[rn] + ", " + "Items: " + items[rn2]);
	    	   itemsarray.add(items[rn2]);
	   	    System.out.println(items[rn2]);
	       }
	    });
	    
	    JButton btnSouth = new JButton("South");
	    southPanel.add(btnSouth,BorderLayout.CENTER);
	    btnSouth.addActionListener(new ActionListener() {
	       @Override
	       public void actionPerformed(ActionEvent evt) {
	    	   if(!worldMap.goTo(2)) {
	    		   JFrame frame = new JFrame("Info");
	    		   JOptionPane.showMessageDialog(frame, "You can't go south");
	    	   }
	         
	         try {
	   	    		String position = worldMap.currentPositionName().toLowerCase();
	   	    		imgLocation = ImageIO.read(new File(imgLocationFilename+position+".jpg"));
	   			} catch (IOException e) {
	   				System.out.println("Images missing");
	   			}
	         int rn = rnd.nextInt(10);
	    		int rn2 = rnd2.nextInt(10);
	    	   canvas.repaint();
	    	   title.setText(worldMap.currentPositionName() + ". Mobs: " + mobs[rn] + ", " + "Items: " + items[rn2]);
	    	   itemsarray.add(items[rn2]);
	   	    System.out.println(items[rn2]);
	       }
	    });
	    
	    JPanel locationInfoPanel = new JPanel(new FlowLayout());
	    title = new JLabel("Information: ");
	    title.setText(worldMap.currentPositionName());
	    locationInfoPanel.add(title);
	    
	    Container cp = getContentPane();
	    cp.setLayout(new BorderLayout());
	    Container map = mapPanel;
	    map.add(canvas, BorderLayout.CENTER);
	    map.add(northPanel, BorderLayout.NORTH);
	    map.add(eastPanel, BorderLayout.EAST);
	    map.add(westPanel, BorderLayout.WEST);
	    map.add(southPanel, BorderLayout.SOUTH);
	    
	    cp.add(map,BorderLayout.CENTER);
	    cp.add(locationInfoPanel,BorderLayout.SOUTH);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Game");
	    pack();           
	    this.setResizable(false);
	    setVisible(true);  
	    requestFocus();  
	}
	
	class MapCanvas extends JPanel {
	      @Override
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         setBackground(CANVAS_BG_COLOR);
	         Image img = imgLocation;
	         g.drawImage(img, 0, 0, 700, 400, null);
	         //sprite.paint(g);
	      }
	   }
	
	public static void main(String[] args) {
	      SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            new Game(); 
	         }
	      });
	}
}
