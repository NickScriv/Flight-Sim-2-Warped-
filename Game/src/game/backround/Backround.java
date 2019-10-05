package game.backround;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Backround 
{
	public static Backround[] backroundArray = new Backround[5];
	public static Backround gameBackround = new GameBackround(1);
	
	
	
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	protected BufferedImage texture;
	protected final int id; 
	
	public Backround(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		backroundArray[id] = this;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, WIDTH, HEIGHT, null);
	}

	public int getId() {
		return id;
	}
}
