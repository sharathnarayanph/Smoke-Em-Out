package com.smoke.GameState;

public abstract class GameState {
	
	protected GameStateManager stateManager;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(java.awt.Graphics2D g);
	public abstract void keyPressed(int key);
	public abstract void keyReleased(int key);

}
