package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//This is for user input
public class KeyboardManager implements KeyListener{
	private boolean [] keys;
	public boolean left, up, down, right;//If true, then move in that direction
	
	public KeyboardManager()
	{
		keys = new boolean [256];
	}
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)//called when a key is pressed 
	{
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed ");
		
	}

	@Override
	public void keyReleased(KeyEvent e)//called when a key is released
	{
		keys[e.getKeyCode()] = false;
		
	}

}
