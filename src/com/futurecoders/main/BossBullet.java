package com.futurecoders.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossBullet extends GameObject{
	Random r = new Random();
	private Handler handler;
	private int timer = 80;
	private int timer2 = 50;
	public BossBullet(float x, float y, ID id, Handler handler) {
		super((int)x, (int)y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
	}
	

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= Game.HEIGHT) handler.removeObject(this);
	
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 5, 5);		
	}


	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 5, 5);
	}
}


