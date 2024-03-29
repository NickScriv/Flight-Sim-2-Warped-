package game.display;

import java.awt.Canvas;

import java.awt.Dimension;

import javax.swing.JFrame;

//display window
public class Display 
{
	private JFrame frame;
	private Canvas canvas;
	
	private String gameTitle;
	private int width;
	private int height;
	
	public Display(String title, int width, int height)
	{
		this.gameTitle = title;
		this.width = width;
		this.height = height;	
		
		makeDisplay();
	}
	
	private void makeDisplay()
	{
		frame = new JFrame(gameTitle);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	

}
