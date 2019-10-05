package game.entity.Lifeforms1;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import java.util.Random;

import game.Handler;
import game.gfx.Assets;


public class Enemy extends Lifeform {
	public ArrayList<Bullet> misilesE = new ArrayList<>();
	private int counter = 101;

	public Enemy(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32);
		speed = 3.1f;
	}

	@Override
	public void update() {
		input();
		move();
		for (int i = 0; i < misilesE.size(); i++) {
			Bullet bullet = misilesE.get(i);
			if (edges.getBottomEdge().contains(bullet.getBounds())) {
				misilesE.remove(bullet);
			}
		}

		if (counter > getRandomNumberInRange(100, 400)) {
			this.fire();
			counter = 0;
		}

		counter++;

		for (Bullet bullet : misilesE) {
			bullet.update();
		}

		bounds.x = (int) x;
		bounds.y = (int) y;
	}

	private void fire() {
		this.misilesE.add(new Bullet(handler, x + 10, y, false));
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 20, 20);
	}

	private void input() {
		xMove = 0;
		yMove = 0;
		if (!edges.overlaps(bounds, edges.getTopEdge())) {
			
			yMove = (speed - 2) + 1;
		}
		if (!edges.overlaps(bounds, edges.getBottomEdge())) {
			
			yMove = (speed - 2) + 1;
		}
		
		if (!edges.overlaps(bounds, edges.getRightEdge())) {
			
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.enemy, (int) x, (int) y, 25, 25, null);
		for (Bullet bullet : misilesE) {
			bullet.render(g);
		}
		

	}

	public void addEntity(Enemy e) {
		for (int i = 0; i < 200; i++) {
			update();
		}
	}

	private int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public ArrayList<Bullet> getEBullets() {
		return misilesE;
	}

}
