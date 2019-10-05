package game;

import java.awt.Graphics;
import java.util.LinkedList;

import game.entity.Lifeforms1.Enemy;

public class Controller 
{
	static LinkedList<Enemy> e = new LinkedList<Enemy>();
	
	
	public static LinkedList<Enemy> getEnemyBounds(){
		return e;
	}

	
	Enemy tempEnemy;
	public void render(Graphics g)
	{
		for (int i = 0;i < e.size();i++ )
		{
			tempEnemy = e.get(i);
			tempEnemy.render(g);
		}
	}
	
	public void update() {
		for (int i = 0;i < e.size();i++ )
		{
			tempEnemy = e.get(i);
			tempEnemy.update();
		}
		

	}
	
	public void addEnemy(Enemy enemy)
	{
		e.add(enemy);
	}
	
	public static void removeEnemy(Enemy enemy)
	{
		e.remove(enemy);
	}
}
