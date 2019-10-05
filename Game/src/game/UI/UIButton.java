package game.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIButton extends UIObject{
	
	private BufferedImage img;
	private ClickListener clicker;

	public UIButton(float x, float y, int width, int height, BufferedImage img, ClickListener clicker ) {
		super(x, y, width, height);
		this.img = img;
		this.clicker = clicker;
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(img, (int)x, (int) y, width, height, null);
		
	}

	@Override
	public void onClick() {
		clicker.onClick();
		
	}

}
