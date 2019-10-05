package game.entity.Lifeforms1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import game.Controller;
import game.Handler;
import game.Music.GameMusic;
import game.gfx.Assets;
import game.states.GameOverState;
import game.states.MenuState;
import game.states.State;

public class Player extends Lifeform {
	private ArrayList<Bullet> misiles = new ArrayList<>();
	int score;
	private LinkedList<Enemy> e = Controller.getEnemyBounds();
	private int counter = 101;
	public Player(Handler handler, float x, float y) {
		super(handler, handler.getWidth()/2, 240, Lifeform.DEFAULT_WIDTH, Lifeform.DEFAULT_HEIGHT);
		score = 0;
	}

	@Override
	public void update() {
		input();
		move();
		counter++;
		for (int i = 0;i < misiles.size();i++ ) {
			Bullet bullet = misiles.get(i);
			if(edges.getTopEdge().contains(bullet.getBounds()))
			{
				misiles.remove(bullet);
			}
		}
		
	    for(Iterator<Enemy> it = e.iterator(); it.hasNext(); ) {
	        Enemy enem = it.next();
	        for(Iterator<Bullet> itb = misiles.iterator(); itb.hasNext(); )
	        {
	        	Bullet bull = itb.next();
	        	if (enem.getBounds().intersects(bull.getBounds()))
	        	{
		            it.remove();
		            score++;
	        	}
	        }
	     
	    }
	    
	    for(Iterator<Enemy> it = e.iterator(); it.hasNext(); ) 
	    {
	        	Enemy enem = it.next();
		        if (edges.getBottomEdge().contains(enem.getBounds()))
		        {
			          it.remove();
		        }
	     }
	     
	    

		
	    for(Iterator<Enemy> it = e.iterator(); it.hasNext(); ) {
	        Enemy enem = it.next();
	        for(Iterator<Bullet> itb = enem.misilesE.iterator(); itb.hasNext(); )
	        {
	        	Bullet bull = itb.next();
	        	if (this.getBounds().intersects(bull.getBounds()))
	        	{
	        		State.setState(new GameOverState(handler)); //player death by enemy bullet
	        		e.clear();
	        		score = 0;
	        		this.x = handler.getWidth()/2;
	        		this.y = 240;
	        		misiles.clear();
	        		GameMusic.pauseMusic();
	        	}	
	        }
	     
	    }
	
		collision();
		getBounds().x = (int) x;
		getBounds().y = (int) y;
	}
	
	
	
	private void input() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyboardManager().up && !edges.overlaps(bounds, edges.getTopEdge()))// If the up key is pressed
		{
			yMove = -speed;
		}
		if (handler.getKeyboardManager().down && !edges.overlaps(bounds, edges.getBottomEdge()))// If the down key is
																								// pressed
		{
			yMove = speed;
		}
		if (handler.getKeyboardManager().left && !edges.overlaps(bounds, edges.getLeftEdge()))// If the left key is
																								// pressed
		{
			xMove = -speed;
		}
		if (handler.getKeyboardManager().right && !edges.overlaps(bounds, edges.getRightEdge()))// If the right key is
																								// pressed
		{
			xMove = speed;
		}
		if (handler.getMouse().isLeftPress() && counter > 15) {
			counter = 0;
			this.fire();
		}
		for (Bullet bullet : misiles) {
			bullet.update();
		}
	
		rotation = (int) (Math.atan2(this.y - y, this.x - x) * 180 / Math.PI) - 90;
	}

	private void fire() {
		this.misiles.add(new Bullet(handler, x + 10, y, true));
	}
	
	public void collision()
	{
		for(int i = 0; i < e.size(); i++)
		{
			if (bounds.intersects(e.get(i).getBounds()))
			{
				State.setState(new GameOverState(handler)); // player death by enemy collision
				e.clear();
        		score = 0;
        		this.x = handler.getWidth()/2;
        		this.y = 240;
        		misiles.clear();
        		GameMusic.pauseMusic();
			}
			
		}

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
		for (Bullet bullet : misiles) {
			bullet.render(g);
		}
		String s = "Enemies killed: " + Integer.toString(score);
		Font font = new Font("serif", Font.BOLD, 20);
		FontMetrics metrics = g.getFontMetrics(font);
		int x = ((handler.getWidth() - metrics.stringWidth(s)) / 2);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(s, x, 25);
		
	}
	
	public Rectangle getBounds() {
		return bounds;
	}

}
