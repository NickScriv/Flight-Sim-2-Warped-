package game.states;

import java.awt.Graphics;

//import game.GameState;
import game.Handler;

//This class is going to hold everything that every state will have
public abstract class State 
{
	//Game state manager
	protected static State current = null;
	
	public static void setState (State s)
	{
		current = s;
	}
	
	public static State getState()
	{
		return current;
	}
	
	

	protected Handler handler;
	
	public State(Handler handler)
	{
		this.handler = handler;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

}
