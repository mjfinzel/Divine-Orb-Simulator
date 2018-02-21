import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DivineOrb extends JFrame {
	public static String whatItem = "Crown of Eyes";
	static int divinesUsed = 0;
	static int blessedUsed = 0;
	static int numMods = 0;//number of mods on the item

	static ArrayList<ItemModifier> mods = new ArrayList<ItemModifier>();

	public static BufferedImage currentImage = Images.load("Images/testImage.png");

	static String implicitRoll="";
	static String firstRoll = "";
	static String secondRoll = "";
	static String thirdRoll = "";
	static String fourthRoll = "";
	static String fifthRoll = "";
	static String sixthRoll = "";

	static String itemName = "";
	static String baseItem = "";
	static String defenseStat = "";
	static String requirements = "";

	public static boolean perfectEs = false;
	public static boolean perfectAccr = false;
	public static boolean perfectLL = false;
	public static boolean perfectML = false;
	public static boolean perfectImp = false;
	public static boolean perfectIir = false;
	public static boolean perfectLres = false;

	Controller ctrl;
	public static void main(String[] args) {
		DivineOrb f = new DivineOrb ();
		f.setSize(416,634);
		f.setVisible(true);
		divineCOE();


	}
	public static int getSizeOfShape(Point position, boolean[][] visited, int size){
		visited[position.x][position.y]=true;
		boolean visitedAtLeastOne = false;
		Point directions[] = {	
				new Point(position.x,position.y-1),
				new Point(position.x,position.y+1),
				new Point(position.x-1,position.y),
				new Point(position.x+1,position.y)
		};
		for(int i = 0; i<directions.length;i++){

			//if this direction is within bounds
			if(!(directions[i].x<0||directions[i].y<0||directions[i].x>currentImage.getWidth()-1&&directions[i].y>currentImage.getHeight()-1)){

				//if this direction hasn't been visited
				if(!visited[directions[i].x][directions[i].y]){

					Color color = new Color(currentImage.getRGB(directions[i].x, directions[i].y),true);
					if(color.getRed()<10&&color.getGreen()<10&&color.getBlue()<10){

						//visit this direction
						size = getSizeOfShape(directions[i],visited,size+1);
					}
				}
			}
		}

		return size;
	}
	public DivineOrb(){
		int size = 1;
		//int result = getSizeOfShape(new Point(0,0),new boolean[currentImage.getWidth()][currentImage.getHeight()],size);
		long resultAK = 0;
		double valueOfTenKanalysisKredits = 2.5;
		double resultISK = 0;
		int accuracy = 99;
		double hoursPerDay = 5;
		int days = 30;
		double secondsPerSample = 16;
		double samplesPerDay = ((3600.0/secondsPerSample)*hoursPerDay);
		double levelsPerDay = samplesPerDay/50.0;
		System.out.println(levelsPerDay*days);
		System.out.println("total levels: "+levelsPerDay*days);
		for(int i = 1;i<=(double)(levelsPerDay*(double)days)+1;i++){
			
			resultAK = resultAK+(i*accuracy);
			resultISK+=accuracy*.05;
			double akValue = (resultAK/10000)*valueOfTenKanalysisKredits;
			if(i%levelsPerDay<=.999){
				System.out.println("Total isk gained by level "+i+", or after "+(int)(i/levelsPerDay)+" days is = "+(int)(resultISK+akValue)+" million, raw isk without AK is: "+(int)resultISK);
				System.out.println("Total boosters: "+resultAK/10000);
			}
		}
		ctrl = new Controller();
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		JPanel drawPanel = new Panel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel.setBackground(Color.BLACK);

		this.addMouseListener(ctrl);
		ctrl.setGamePanel(drawPanel);

		this.setFocusable(true);
		pane.add(drawPanel);
		this.setTitle("Divine Orb Simulator");
	}
	public void addModifier(){
		//add any modifier that has a ilvl requirement lower than the ilvl of the item to the list of possible modifiers

	}

	static int randomNumber(int min, int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	public static void divineCOE(){

		perfectEs = false;
		perfectAccr = false;
		perfectLL = false;
		perfectML = false;
		perfectIir=false;
		perfectImp=false;

		int es = randomNumber(120,150);//accuracy
		int accr = randomNumber(200,250);//energy shield
		int LL = randomNumber(2,4);//life leech
		int ML = randomNumber(1,2);//mana leech
		itemName = "Crown of Eyes";
		baseItem = "Hubris Circlet";
		firstRoll=("+"+accr+" to Accuracy Rating");
		secondRoll=es+"% increased Energy Shield";
		thirdRoll=("-30% to Fire Resistance");
		fourthRoll=("+"+LL+"% of Physical Attack Damage Leeched as Life");
		fifthRoll=("+"+ML+"% of Physical Attack Damage Leeched as Mana");
		sixthRoll=("Modifiers to Spell Damage also apply to Attack Damage");

		defenseStat = "Energy Shield: "+(100+es);
		requirements = "Requires Level 69, 154 Int";
		if(es==150){
			perfectEs=true;
		}
		if(accr==250){
			perfectAccr=true;
		}
		if(LL==4){
			perfectLL=true;
		}
		if(ML==2){
			perfectML=true;
		}

	}
	public static void divineAndvarius(){
		perfectEs = false;
		perfectAccr = false;
		perfectLL = false;
		perfectML = false;
		perfectIir=false;

		int iir = randomNumber(50,70);//energy shield
		int imp = randomNumber(6,15);
		itemName = "Andvarius";
		baseItem = "Gold Ring";

		firstRoll="+10 to Dexterity";
		secondRoll=(iir+"% increased Rarity of Items found");
		thirdRoll="-20% to all Elemental Resistances";
		fourthRoll="";
		fifthRoll="";
		sixthRoll="";
		defenseStat = "Requires Level 8";

		if(iir==70){
			perfectIir=true;
		}
	}
	public static void blessAndvarius(){
		perfectEs = false;
		perfectAccr = false;
		perfectLL = false;
		perfectML = false;
		perfectImp=false;
		int imp = randomNumber(6,15);
		implicitRoll = imp+"% increased Rarity of Items found";

		if(imp==15){
			perfectImp=true;
		}

	}
	public static void divineShavronnes(){
		perfectEs = false;
		perfectAccr = false;
		perfectLL = false;
		perfectML = false;
		perfectLres=false;
		perfectIir=false;
		int es = randomNumber(140,200);//energy shield
		int lres = randomNumber(30,40);//lightning resist
		itemName = "Shavronne's Wrappings";
		baseItem = "Occultist's Vestement";
		requirements = "Requires Level 62, 180 Int";
		firstRoll=es+"% increased Energy Shield";
		secondRoll=("10% increased Energy Shield Cooldown Recovery");
		thirdRoll="+"+lres+"% to Lightning Resistance";
		fourthRoll="Reflects 1-250 Lightning Damage to Melee Attackers";
		fifthRoll="Chaos Damage does not Bypass Energy Shield";
		sixthRoll="";

		defenseStat = "Energy Shield: "+(140+((140*es)/100));

		if(es==200){
			perfectEs=true;
		}
		if(lres==40){
			perfectLres=true;
		}
	}
	public static void blessShavronnes(){
		perfectAccr = false;
		perfectLL = false;
		perfectML = false;
		perfectImp=false;
		int imp = randomNumber(3,10);
		implicitRoll = imp+"% increased Spell Damage";
		if(imp==10){
			perfectImp=true;
		}
	}
	public void Draw(Graphics g){

	}

}
