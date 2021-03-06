package com.smoke.Villain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import com.smoke.Render.*;
import com.smoke.WorldMap.*;

public class NamekPests extends Villain {
	
	private BufferedImage[] sprites;
	
	public NamekPests(TileMap tm) {
		
		super(tm);
		
		moveSpeed = 0.3;
		maxSpeed = 0.3;
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
		
		width = 30;
		height = 30;
		cwidth = 20;
		cheight = 20;
		
		health = maxHealth = 2;
		damage = 1;
		
		// Load Namek Pests
		try {
			
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/saibamen.gif"));
			
			sprites = new BufferedImage[3];
			for(int i = 0; i < sprites.length; i++) 
				sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(300);
		
		right = true;
		facingRight = true;
		
	}
	
	private void getNextPosition() {
		
		// Pest Movement
		if(left) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) 
				dx = -maxSpeed;
		}
		else if(right) {
			dx += moveSpeed;
			if(dx > maxSpeed) 
				dx = maxSpeed;
		}
		
		if(falling) {
			dy += fallSpeed;
		}
		
	}
	
	public void update() {
		
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		if(flinching) {
			long elapsed =
				(System.nanoTime() - flinchTimer) / 1000000;
			if(elapsed > 400)
				flinching = false;
		}
		
		// To check end of wall and move in other direction
		if(right && dx == 0) {
			right = false;
			left = true;
			facingRight = false;
		}
		else if(left && dx == 0) {
			right = true;
			left = false;
			facingRight = true;
		}
		
		animation.update();
		
	}
	
	public void draw(Graphics2D g) {
		
		setMapPosition();
		
		super.draw(g);
		
	}
	
}
