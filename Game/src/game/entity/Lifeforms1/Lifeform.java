package game.entity.Lifeforms1;

import game.Handler;
import game.entity.Entity;

public abstract class Lifeform extends Entity {
	public final static int DEFAULT_HEALTH = 10;
	public final static float DEFAULT_SPEED = 3.5f;
	public final static int DEFAULT_WIDTH = 32;
	public final static int DEFAULT_HEIGHT = 32;

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Lifeform(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
	}

	public void moveX() {
		x += xMove;
	}

	public void moveY() {
		y += yMove;
	}

	public void move() {
		moveX();
		moveY();
	}

	// get and set methods
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
