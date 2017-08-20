package com.smoke.Worlds;

import java.awt.*;

import com.smoke.GameState.GameState;
import com.smoke.GameState.GameStateManager;
import com.smoke.WorldMap.TileMap;
  
public class PlanetNamek extends GameState {
	
	private TileMap tileMap;

	public PlanetNamek(GameStateManager gsm) {
		this.stateManager = gsm;
		init();
	}
	
	public void init() {
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(1);		
		
	}
	
	public void update() {}
	public void draw(Graphics2D g) {

		tileMap.draw(g);
	}
	public void keyPressed(int key) {}
	public void keyReleased(int key) {}

}
