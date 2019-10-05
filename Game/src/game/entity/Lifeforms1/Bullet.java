package game.entity.Lifeforms1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.entity.Entity;

public class Bullet extends Entity {
	
	private int speed;
	private int timer = 0;
	private boolean player;

	public Bullet(Handler handler, float x, float y, boolean player) {
		super(handler, x, y, 5, 10);
		getBounds().x = (int) x;
		getBounds().y = (int) y;
		this.player = player;
		if(player)
			speed = 10;
		else
			speed = 5;
	}
	

	
	@Override
	public void update() {
		if (player == true)
		{
		y -= speed;
		}
		else 
		{
			y += speed;
		}
		timer += 10;
		getBounds().x = (int) x;
		getBounds().y = (int) y;
	}
	
	public boolean shouldDie() {
		return timer > 500;
	}

	@Override
	public void render(Graphics g) {
		if(player)
		{
			g.setColor(Color.green);
		}
		else
		{
			g.setColor(Color.red);
		}
		
		 
		g.fillRect(bounds.x,bounds.y, bounds.width, bounds.height);
	}

}
