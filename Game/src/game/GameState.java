package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import game.display.Display;
import game.gfx.Assets;
import game.gfx.ImageLoader;
import game.gfx.SpriteSheet;
import game.input.KeyboardManager;
import game.input.MouseManager;
import game.states.GameOverState;
import game.states.Gamestate;
import game.states.MenuState;
import game.states.State;

public class GameState implements Runnable 
{
	
	private Thread thread;
	private boolean running;
	private BufferStrategy bs;
	private Graphics g;
	
	
	private int width;
	private int height;
	

	public String title;
	private Display display;
	
	//states
	private State gameS;
	public State menuS;
	private State gameOverS;
	
	//input
	private KeyboardManager keyboardManager;
	private MouseManager mouse;
	
	//handler
	private Handler handler;
	
	
	public GameState(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		keyboardManager = new KeyboardManager();
		mouse = new MouseManager();
		
	}
	
	private void init()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyboardManager);//Adding a key listener to the display window which allows access to keyboard
		display.getFrame().addMouseListener(mouse);//Adding a mouse listener to the display window which allows access to mouse
		display.getFrame().addMouseMotionListener(mouse);
		display.getCanvas().addMouseListener(mouse);//Adding to canvas to ensure it will work on all computers
		display.getCanvas().addMouseMotionListener(mouse);
		Assets.init(); //Loads in all the sprites and objects only once
		handler = new Handler(this);
		//setGameS(new Gamestate(handler));//Passing the game object to all of the states
		
		gameS = new Gamestate(handler);
		menuS = new MenuState(handler);  
		State.setState(menuS);
		
	}
	

	
	private void update()
	{
		keyboardManager.update();
		if(State.getState() != null)
		{
			State.getState().update();
		}
		
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear
		g.clearRect(0, 0, width, height);
		//draw
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		
		
		
		//end draw
		
		bs.show();
		g.dispose();
	}
	
	public int getWidth() 
	{
		return width;
	}

	public int getHeight() 
	{
		return height;
	}
	
	public void run()
	{
		init();
		/*This section of code involving delta, fps, and time 
		 * allows the game to run at the same speed across all computers (60fps).
		 */
		int fps = 60;
		double timePerUpdate = 1000000000/fps; //To measure time in nanoseconds instead of seconds
		double delta = 0;
		long now, lastTime = System.nanoTime(); //returns amount of time in nanoseconds the computer is running at
		long timer = 0;
		int updates = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now-lastTime)/ timePerUpdate;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1)
			{
				update();
				render();
				updates++;
				delta--;
			}
			
			if (timer >= 1000000000)
			{
				System.out.println("Updates: " + updates);
				updates = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyboardManager getKeyboardManager()
	{
		return keyboardManager;
	}
	
	public MouseManager getMouseManager()
	{
		return mouse;
	}
	
	public synchronized void start()
	{
		if(!running)
		{
			running = true;
			thread = new Thread(this);
			thread.start();
	    }
	}
	
	public synchronized void stop()
	{
		if (running)
		{
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

	public State getGameS() {

		return gameS;
		
	}

	public void setGameS(State gameS) {
		this.gameS = gameS;
	}

	public State getGameOverS() {
		
		return gameOverS;
	}

	public void setGameOverS(State gameOverS) {
		
		this.gameOverS = gameOverS;
	}

}
