package com.futurecoders.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{
	Random r = new Random();
	private Handler handler;
	private int timer = 80;
	private int timer2 = 50;
	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super((int)x, (int)y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	}
	

	public void tick() {
		x += velX;
		y += velY;
		
		if(timer <= 0) velY = 0;
		else timer--;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0) {
			if(velX == 0) velX = 2;
			int spawn = r.nextInt(10);
			if(spawn == 0) {
				handler.addObject(new BossBullet(x+50, y+48, ID.EnemyBoss, handler));
			}
		}
		
//		if (y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH-64) velX *= -1;
		
//		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 64, 64, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 64, 64);		
	}


	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}
}

