package game.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject 
{
	protected int width, height;
	protected float x, y;
	protected Rectangle bounds;
	protected boolean hovering = false; // Added by Adrian
	
	public UIObject(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	
	public abstract void Update();
	
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	
	// Added by Adrian	
		public void onMouseMove(MouseEvent e)
		{
			if (bounds.contains(e.getX(), e.getY()))
				hovering = true;
			else
				hovering = false;
		}
	// Added by Adrian	
		
		public void onMouseRelease(MouseEvent e)
		{
			if(bounds.contains(e.getX(), e.getY()))
			{
				onClick();
			}
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

	


	
}
