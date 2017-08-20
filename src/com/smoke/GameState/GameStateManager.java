package com.smoke.GameState;

import java.util.ArrayList;
import com.smoke.Worlds.*;

public class GameStateManager {
	
	private ArrayList<GameState> gameStates;
	private int currentState;
	
	public static final int LOADPAGESTATE = 0;
	public static final int NAMEK = 1;
	
	public GameStateManager() {
		
		gameStates = new ArrayList<GameState>();
		
		currentState = LOADPAGESTATE;
		gameStates.add(new LoadPageState(this));
		gameStates.add(new PlanetNamek(this));
	}
	
	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void update() {
		gameStates.get(currentState).update();
	}
	
	public void draw(java.awt.Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}
	
	public void keyPressed(int key) {
		gameStates.get(currentState).keyPressed(key);
	}
	
	public void keyReleased(int key) {
		gameStates.get(currentState).keyReleased(key);
	}
	
}









