


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;






import javax.swing.JPanel;


public class Panel extends JPanel{

	private static final long serialVersionUID = 7734877696044080629L;

	public static int Chapter;
	public static int mapLength = 20;
	public static int mapHeight = 20;
	public static enum Gamestate{appletui_init,Controller_init};

	//Controller ctrl = new Controller();


	public static Gamestate gamestate;
	public static boolean game_is_running = false;
	final int TICKS_PER_SECOND = 40;
	final int SKIP_TICKS = 1000/TICKS_PER_SECOND;
	final int MAX_FRAMESKIP = 5;
	long starttime = System.currentTimeMillis();
	int tickcount = 0;
	int next_game_tick = (int) GetTickCount();
	long tickstart=0;
	boolean go_on=false;
	private BufferedImage divine = Images.load("/Images/Divine Orb.png");
	private BufferedImage blessed = Images.load("/Images/Blessed Orb.png");

	private BufferedImage nameplate = Images.load("/Images/NamePlate.png");
	private BufferedImage COE = Images.load("/Images/CrownOfEyes.png");
	private BufferedImage Andvarius = Images.load("/Images/Andvarius.png");
	private BufferedImage sWraps = Images.load("/Images/ShavronnesWrappings.png");
	private BufferedImage statSeperator = Images.load("/Images/StatSeperator.png");

	int sleep_time = 0;

	public long GetTickCount(){
		return (System.currentTimeMillis()-starttime);
	}
	public Panel(){

		this.setDoubleBuffered(true);



	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Draw(g);


	}


	public void Draw(Graphics g){
		int descriptionY=180;//what y coordinate to start drawing the item mods at

		g.drawImage(divine, 350, 0,50, 50, null);
		g.drawImage(blessed, 300, 0,50, 50, null);
		g.drawImage(statSeperator, 65, 130,270, 2, null);
		if(DivineOrb.whatItem=="Crown of Eyes"){
			g.drawImage(statSeperator, 65, 160,270, 2, null);
			descriptionY=180;
			DivineOrb.numMods=6;
		}
		else if(DivineOrb.whatItem=="Andvarius"){
			descriptionY=180;
			DivineOrb.numMods=3;
			g.drawImage(statSeperator, 65, 160,270, 2, null);
		}
		else if(DivineOrb.whatItem=="Shavronne's Wrappings"){
			descriptionY=210;
			DivineOrb.numMods=5;
			g.drawImage(statSeperator, 65, 160,270, 2, null);
			g.drawImage(statSeperator, 65, 190,270, 2, null);
		}
		g.drawImage(statSeperator, 65, descriptionY+(DivineOrb.numMods*20),270, 2, null);
		g.drawImage(nameplate, 0, 50,400, 50, null);
		Font font = new Font("Fontin",Font.BOLD,14);;
		g.setFont(font);
		g.setColor(new Color(175,96,37));
		if(DivineOrb.whatItem=="Crown of Eyes"){
			g.drawImage(COE, 140, 315,125, 125, null);
		}
		else if(DivineOrb.whatItem=="Andvarius"){
			g.drawImage(Andvarius, 140, 315,125, 125, null);
			DivineOrb.requirements=DivineOrb.implicitRoll;
		}
		else if(DivineOrb.whatItem=="Shavronne's Wrappings"){
			g.drawImage(sWraps, 140, 315,125, 125, null);
			
		}
		g.drawImage(COE, 0, 550,50, 50, null);
		g.drawImage(Andvarius, 50, 550,50, 50, null);
		g.drawImage(sWraps, 100, 550,50, 50, null);

		//draw item name
		g.drawString(DivineOrb.itemName, 200-(DivineOrb.itemName.length()*3), 70);
		//draw item type
		g.drawString(DivineOrb.baseItem, 200-(DivineOrb.itemName.length()*3), 90);

		font = new Font("Fontin",Font.BOLD,12);
		g.setColor(Color.gray);
		g.setFont(font);

		//draw item defenses

		g.drawString(DivineOrb.defenseStat, 200-(DivineOrb.defenseStat.length()*3), 120);
		g.drawString(DivineOrb.requirements, 200-(DivineOrb.requirements.length()*3), 150);
		//draw item requirements
		if(DivineOrb.whatItem=="Andvarius"||DivineOrb.whatItem=="Shavronne's Wrappings"){
			font = new Font("Fontin",Font.BOLD,12);
			g.setColor(new Color(104,136,255));
			g.setFont(font);
		}
		if(DivineOrb.whatItem=="Shavronne's Wrappings"){
			g.drawString(DivineOrb.implicitRoll, 200-(DivineOrb.requirements.length()*3), 180);
		}
		else if(DivineOrb.whatItem=="Andvarius"){
			g.drawString(DivineOrb.requirements, 200-(DivineOrb.requirements.length()*3), 150);
		}
		
		

		font = new Font("Fontin",Font.BOLD,12);
		g.setColor(new Color(104,136,255));
		g.setFont(font);
		//draw item mods

		g.drawString(DivineOrb.firstRoll, 200-(DivineOrb.firstRoll.length()*3), descriptionY+0);
		g.drawString(DivineOrb.secondRoll, 200-(DivineOrb.secondRoll.length()*3),descriptionY+20);
		g.drawString(DivineOrb.thirdRoll, 200-(DivineOrb.thirdRoll.length()*3), descriptionY+40);
		g.drawString(DivineOrb.fourthRoll, 200-(DivineOrb.fourthRoll.length()*3),descriptionY+60);
		g.drawString(DivineOrb.fifthRoll, 200-(DivineOrb.fifthRoll.length()*3), descriptionY+80);
		g.drawString(DivineOrb.sixthRoll, 200-(DivineOrb.sixthRoll.length()*3), descriptionY+100);

		//draw statistics
		font = new Font("Fontin",Font.BOLD,12);
		g.setColor(Color.green);
		g.setFont(font);
		//draw item mods
		g.drawString("Divines Used: " + DivineOrb.divinesUsed, 15, 15);
		g.drawString("Blessed Orbs Used: " + DivineOrb.blessedUsed, 15, 35);
		if(DivineOrb.perfectAccr){
			g.drawString("*Perfect Accuracy!*", 146,440);
		}
		if(DivineOrb.perfectEs){
			g.drawString("*Perfect Energy Shield!*", 137,460);
		}
		if(DivineOrb.perfectLL){
			g.drawString("*Perfect Life Leech!*", 143,480);
		}
		if(DivineOrb.perfectML){
			g.drawString("*Perfect Mana Leech!*", 143,500);
		}
		if(DivineOrb.perfectImp){
			g.drawString("*Perfect Implicit!*", 143,440);
		}
		if(DivineOrb.perfectIir){
			g.drawString("*Perfect Item Rarity!*", 143,460);
		}
		if(DivineOrb.perfectLres){
			g.drawString("*Perfect Lightning Resist!*", 143,480);
		}

	}
}
