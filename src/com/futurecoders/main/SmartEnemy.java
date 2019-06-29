package com.futurecoders.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class SmartEnemy extends GameObject{
	Random r = new Random();
	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super((int)x, (int)y, id);
		
		this.handler = handler;
		
		for(int i=0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
		velX = r.nextInt(5);
		velY = r.nextInt(10);
	}
	

	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x-player.getX())*x-player.getX()) + (y-player.getY())*(y-player.getY());
		
		velX = (int) ((-1.0/distance) * diffX);
		velY = (int) ((-1.0/distance) * diffY);
		
		if (y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH-16) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int)x, (int)y, 16, 16);		
	}


	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
}
