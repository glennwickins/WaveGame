package com.futurecoders.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;		
	}

	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 500) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(hud.getLevel() == 2) {
				handler.addObject(new EnemyBoss((Game.WIDTH/2), -120, ID.EnemyBoss, handler));				
			}

		
//			if(hud.getLevel()%5 == 0) {
//				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
//			}
//			
//			if(hud.getLevel() == 10) {
//				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
//			}
		}
		
	}
}
