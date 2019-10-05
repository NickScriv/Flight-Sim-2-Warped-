package game.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
//Main menu buttons that launch and exit the game
public class UIImageButton extends UIObject{

	private BufferedImage[] images;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void Update() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering)
			g.drawImage(images[1], (int) x, (int) y, width, height, null); //Uses the texture when the mouse is hovering over the button
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null); //Uses the texture when the mouse is not hovering over the button
	}// Added by Adrian

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
