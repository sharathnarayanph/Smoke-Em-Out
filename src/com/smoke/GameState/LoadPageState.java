package com.smoke.GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.smoke.WorldMap.Background;

public class LoadPageState extends GameState {
	
private Background bg;
	
	private int choice = 0;
	private String[] options = { "START", "EXIT"};
	
	private Color titleColor;
	private Font titleFont;	
	private Font optionFont;
	
	public LoadPageState(GameStateManager stateManager) {
		
		this.stateManager = stateManager;
		
		try {
			
			bg = new Background("/Backgrounds/load.gif", 1);
			bg.setVector(-0.1, 0);
			
			titleColor = Color.BLACK;
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);
			optionFont = new Font("Arial", Font.PLAIN, 12);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	
	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		
		bg.draw(g);
		
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Dragon Ball", 50, 70);
		g.drawString("Smoke 'em Out", 50, 100);
		
		g.setFont(optionFont);
		for(int i = 0; i < options.length; i++) {
			if(i == choice)
				g.setColor(Color.YELLOW);
			else 
				g.setColor(Color.BLACK);
			g.drawString(options[i], 145, 140 + i * 15);
		}
		
	}
	
	private void select() {

		switch(choice)
		{
			case 0: stateManager.setState(GameStateManager.NAMEK);
					break;
			case 1: System.exit(0);
					break;
			default: System.exit(0);
					 break;
		}
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			choice--;
			if(choice == -1)
				choice = options.length - 1;
		}
		if(k == KeyEvent.VK_DOWN) {
			choice++;
			if(choice == options.length) 
				choice = 0;
		}
	}
	public void keyReleased(int k) {}
	
}
