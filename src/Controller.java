

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;



public class Controller extends JPanel implements MouseListener {

	public static int xpos=0;
	public static int ypos=0;
	public static int firstxpos=0;
	public static int firstypos=0;
	public static int lastxpos=0;
	public static int lastypos=0;
	public static int lastdir=0;
	int movement =0;
	int xMove=0;
	int yMove=0;
	static int move=0;
	public static boolean Zispressed = false;
	public static boolean isSelected=false;
	public boolean isRight=false;
	public boolean isLeft=false;
	public boolean isDown=false;
	public boolean isUp=false;
	int lastArrow = 0;
	int tileID=0;
	private JPanel gamePanel;
	long starttime = 0;

	//BattleshorePanel bPanel = new BattleshorePanel(bshore);
	private static boolean[] keyboardState = new boolean[525];

	public Controller(){
		this.setDoubleBuffered(true);

	}
	public static boolean keyboardKeyState(int key)
	{
		return keyboardState[key];
	}

	public void setGamePanel(JPanel panelRef) {
		gamePanel = panelRef;
		gamePanel.addMouseListener(this);
	}
	public void updateAll(){
		if (gamePanel != null)
			gamePanel.getParent().repaint();
		repaint();
	}
	public void Updateypos(int y){
		ypos = y;
	}


	public void mouseClicked(MouseEvent e){
		
		if(e.getX()>350&&e.getY()<=50){
			if(DivineOrb.whatItem=="Crown of Eyes"){
				DivineOrb.divineCOE();
				DivineOrb.divinesUsed++;
				updateAll();
			}
			else if(DivineOrb.whatItem=="Andvarius"){
				DivineOrb.divineAndvarius();
				DivineOrb.divinesUsed++;
				updateAll();
			}
			else if(DivineOrb.whatItem=="Shavronne's Wrappings"){
				DivineOrb.divineShavronnes();
				DivineOrb.divinesUsed++;
				updateAll();
			}
				
			
		}
		else if(e.getX()>300&&e.getY()<=50&&e.getX()<350&&e.getY()>=0){
			if(DivineOrb.whatItem=="Crown of Eyes"){
				
			}
			else if(DivineOrb.whatItem=="Andvarius"){
				DivineOrb.blessAndvarius();
				DivineOrb.blessedUsed++;
				updateAll();
			}
			else if(DivineOrb.whatItem=="Shavronne's Wrappings"){
				DivineOrb.blessShavronnes();
				DivineOrb.blessedUsed++;
				updateAll();
			}
				
			
		}
		else if(e.getX()>0&&e.getY()>=550&&e.getX()<=50&&e.getY()<=600){
			DivineOrb.whatItem="Crown of Eyes";
			DivineOrb.divineCOE();
			DivineOrb.divinesUsed=0;
			DivineOrb.blessedUsed=0;
			updateAll();
		}
		else if(e.getX()>50&&e.getY()>=550&&e.getX()<=100&&e.getY()<=600){
			DivineOrb.whatItem="Andvarius";
			DivineOrb.divineAndvarius();
			DivineOrb.blessAndvarius();
			DivineOrb.divinesUsed=0;
			DivineOrb.blessedUsed=0;
			updateAll();
		}
		else if(e.getX()>100&&e.getY()>=550&&e.getX()<=150&&e.getY()<=600){
			DivineOrb.whatItem="Shavronne's Wrappings";
			DivineOrb.divineShavronnes();
			DivineOrb.blessShavronnes();
			DivineOrb.divinesUsed=0;
			DivineOrb.blessedUsed=0;
			updateAll();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


}
