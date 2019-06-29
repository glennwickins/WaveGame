package com.futurecoders.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	Random r = new Random();
	Handler handler;
	
	public Player(float x, float y, ID id, Handler handler) {
		super((int)x, (int)y, id);
		this.handler = handler;
		
		}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp((int)x, 0, Game.WIDTH -38);
		y = Game.clamp((int)y, 0, Game.HEIGHT -61);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 32, 32, 0.08f, handler));
		
		collision();
	}
	
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.EnemyBoss) {				
				if(getBounds().intersects(tempObject.getBounds())) {
					//Collision code
					HUD.HEALTH -=2;
				}
			}
		}
	}
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g. setColor(Color.green);
		g2d.draw(getBounds());
		
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);
        g.setColor(Color.white);
        g.drawRect((int)x , (int)y, 32, 32);
	}
}
