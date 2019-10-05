package game.edges;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;

public class Edges
{
	private Rectangle bottomEdge , topEdge, rightEdge, leftEdge;
	
	
	public Edges()
	{
		bottomEdge = new Rectangle(0,360,1500,1000 );
		topEdge = new Rectangle(0,-200,640,200);
		rightEdge = new Rectangle(640,0,50,360);
		leftEdge = new Rectangle(-50,0,50,360);
	
	}
	
	public Rectangle getBottomEdge() {
		return bottomEdge;
	}

	public Rectangle getTopEdge() {
		return topEdge;
	}

	public Rectangle getRightEdge() {
		return rightEdge;
	}

	public Rectangle getLeftEdge() {
		return leftEdge;
	}

	
	public boolean overlaps (Rectangle r, Rectangle s) 
	{
	    return s.x < r.x + r.width && s.x + s.width > r.x && s.y < r.y + r.height && s.y + s.height > r.y;
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.GRAY );
		g.fillRect(bottomEdge.x, bottomEdge.y, bottomEdge.width, bottomEdge.height);
		g.fillRect(rightEdge.x, rightEdge.y, rightEdge.width, rightEdge.height);
		g.fillRect(leftEdge.x, leftEdge.y, leftEdge.width, leftEdge.height);
		g.fillRect(topEdge.x, topEdge.y, topEdge.width, topEdge.height);
	}
}
