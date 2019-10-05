package game;

import game.input.KeyboardManager;
import game.input.MouseManager;
//This class allows us to pass just one object to access other objects in the program
public class Handler 
{
	private GameState game;
	
	
	public Handler(GameState game)
	{
		this.game = game;
	}
	
	public KeyboardManager getKeyboardManager()
	{
		return game.getKeyboardManager();
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}

	public GameState getGame() 
	{
		return game;
	}


	public void setGame(GameState game) 
	{
		this.game = game;
	}
	
	public MouseManager getMouse()
	{
		return game.getMouseManager();
	}

}
