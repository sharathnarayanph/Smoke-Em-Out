package com.smoke.WorldMap;

import com.smoke.Main.GamePanel;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Background {
	
	private BufferedImage image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private double moveScale;
	
	public Background(String res, double scale) {		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(res));
			moveScale = scale;
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void setPosition(double x, double y) {
		this.x = (x * moveScale) % GamePanel.WIDTH;
		this.y = (y * moveScale) % GamePanel.HEIGHT;
	}
	
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(image, (int)x, (int)y, null);
		
		if(x < 0)
			g.drawImage(image, (int)x + GamePanel.WIDTH, (int)y, null);
		if(x > 0)
			g.drawImage(image, (int)x - GamePanel.WIDTH, (int)y, null);
	}
	
}






