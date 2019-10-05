package game.states;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import game.GameState;
import game.Handler;
import game.Music.GameMusic;
import game.UI.ClickListener;
import game.UI.UIImageButton;
import game.UI.UIManager;
import game.gfx.Assets;
//Main menu
public class MenuState extends State
{
	private UIManager uiManager;
	
	public MenuState(Handler handler)
	{
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouse().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(50, 200, 128, 64, Assets.btn_start, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouse().setUIManager(uiManager);
				System.out.println("testM");
				State.setState(handler.getGame().getGameS());
				GameMusic.startMusic("C:/Users/nickscriv123/eclipse-workspace/Game/res/Moon Garden.wav");
				
			}
			}));
		
		uiManager.addObject(new UIImageButton(450, 200, 128, 64, Assets.btn_exit, new ClickListener() {

			@Override
			public void onClick() {
				System.exit(0);
			}
			
		}));
	}
	
	@Override
	public void update(){
		
		
		uiManager.Update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menuBackground, 0, 0, 640, 360, null);
		String s = "Flight Sim 2: Warped!";
		Font font = new Font("News Gothic MT", Font.ITALIC, 40);
		FontMetrics metrics = g.getFontMetrics(font);
		int x = ((handler.getWidth() - metrics.stringWidth(s)) / 2);
		//int y = ((handler.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(s, x, 50);
		g.drawImage(Assets.player, 255, 250, 32, 32, null);
		g.drawImage(Assets.player, 307, 300, 32, 32, null);
		g.drawImage(Assets.player, 355, 250, 32, 32, null);
		g.drawImage(Assets.player, 205, 300, 32, 32, null);
		g.drawImage(Assets.player, 405, 300, 32, 32, null);
		uiManager.render(g);
	}
}
