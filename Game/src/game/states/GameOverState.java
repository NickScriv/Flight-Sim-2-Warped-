package game.states;

import java.awt.Graphics;

import game.GameState;
import game.Handler;
import game.Music.GameMusic;
import game.UI.ClickListener;
import game.UI.UIImageButton;
import game.UI.UIManager;
import game.gfx.Assets;
//Game over screen that gets displayed when the player dies
public class GameOverState extends State 
{
	private UIManager uiManager;
	
	public GameOverState(Handler handler)
	{
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouse().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(30, 200, 128, 64, Assets.btn_restart, new ClickListener(){
			
			@Override
			public void onClick() {
				handler.getMouse().setUIManager(uiManager);
				
				State.setState(handler.getGame().getGameS());
				System.out.println("testO");
				GameMusic.resumeMusic();
				
			}
		}));
		
		uiManager.addObject(new UIImageButton(485, 200, 128, 64, Assets.btn_exit, new ClickListener() {

			@Override
			public void onClick() {
				System.exit(0);
			}
			
		}));
	}

	@Override
	public void update() {
		
		uiManager.Update();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameOverBackground, 0, 0, 640, 360, null);
		uiManager.render(g);
	}

}

