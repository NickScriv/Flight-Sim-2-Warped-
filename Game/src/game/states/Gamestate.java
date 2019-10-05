package game.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import game.Controller;
//import game.GameState;
import game.Handler;
import game.backround.Backround;
import game.edges.Edges;
import game.entity.Lifeforms1.Bullet;
import game.entity.Lifeforms1.Enemy;
import game.entity.Lifeforms1.Player;

public class Gamestate extends State
{
	private Player player;
	private Edges edges;
	public Controller c;
	private int counter = 101;
	
	
	public Gamestate(Handler handler) 
	{	
		super(handler);
		edges = new Edges();
		player = new Player(handler, 100,100);
		c = new Controller();
	}

	@Override
	public void update() 
	{
		player.update();
		c.update();
		if (counter >getRandomNumberInRange(50, 200))
		{
			counter = 0;
			c.addEnemy(new Enemy(handler, getRandomNumberInRange(0, 650), getRandomNumberInRange(-50, -10)));
			c.addEnemy(new Enemy(handler, getRandomNumberInRange(0, 650), getRandomNumberInRange(-50, -10)));
			c.addEnemy(new Enemy(handler, getRandomNumberInRange(0, 650), getRandomNumberInRange(-50, -10)));

		}
		counter++;
	}

	@Override
	public void render(Graphics g) 
	{
		
		Backround.backroundArray[1].render(g, 0, 0);
		edges.render(g);
		player.render(g);
		c.render(g);
	}
	
	private  int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
}
