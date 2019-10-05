package game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.edges.Edges;

public abstract class Entity 
{
	protected float x, y;
	protected int width, height;
	protected int rotation;
	protected Handler handler;
	protected Rectangle bounds;
	protected Edges edges;

	public Entity(Handler handler, float x, float y, int width, int height) //Starting position of entity
	{
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setBounds(new Rectangle((int) x,(int) y, width, height));
		setEdges(new Edges());
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public abstract void update();
	
	
	public abstract void render(Graphics g);

	public Edges getEdges() {
		return edges;
	}

	public void setEdges(Edges edges) {
		this.edges = edges;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	

}
