package game.backround;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameOverBackground 
{
	public static GameOverBackground[] gameOverBackgroundArray = new GameOverBackground[5];
	public static GameOverBackground gameOverBackground = new OverBackground(1);
	
	
	
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	protected BufferedImage overTexture;
	protected final int overId; 
	
	public GameOverBackground(BufferedImage overTexture,int overId)
	{
		this.overTexture = overTexture;
		this.overId = overId;
		
		gameOverBackgroundArray[overId] = this;
	}
	
	public void update()
	{
		
	}

	public void render(Graphics g, int x, int y)
	{
		g.drawImage(overTexture, x, y, WIDTH, HEIGHT, null);
	}

	public int getId() {
		return overId;
	}
}
