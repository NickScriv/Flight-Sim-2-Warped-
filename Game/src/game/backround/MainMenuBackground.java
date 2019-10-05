package game.backround;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MainMenuBackground 
{
	public static MainMenuBackground[] menuBackgroundArray = new MainMenuBackground[5];
	public static MainMenuBackground menuBackground = new MenuBackground(1);
	
	
	
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	protected BufferedImage menuTexture;
	protected final int menuId; 
	
	public MainMenuBackground(BufferedImage menuTexture, int menuId)
	{
		this.menuTexture = menuTexture;
		this.menuId = menuId;
		
		menuBackgroundArray[menuId] = this;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(menuTexture, x, y, WIDTH, HEIGHT, null);
	}

	public int getId() {
		return menuId;
	}
}
