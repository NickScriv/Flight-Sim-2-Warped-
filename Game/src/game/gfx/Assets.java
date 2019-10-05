package game.gfx;

import java.awt.image.BufferedImage;

//Loads all of the textures, images and sounds.
public class Assets 
{
	
	public static final int width = 32, height = 32;
	
	public static BufferedImage player, enemy, laser, gameBackround, menuBackground, gameOverBackground; // I added menuBackground and gameOverbackground
	public static BufferedImage[] btn_start; //Added by Adrian. Button textures for Start button; I also added a Buttons folder to res/textures.
	public static BufferedImage[] btn_exit; //Added by Adrian. Button textures for Exit button
	public static BufferedImage[] btn_restart; //Added by Adrian. Button textures for Restart Button
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet blueRestart = new SpriteSheet(ImageLoader.loadImage("/textures/Buttons/BlueRestartButton.png"));//Added by Adrian
		SpriteSheet greenRestart = new SpriteSheet(ImageLoader.loadImage("/textures/Buttons/GreenRestartButton.png"));//Added by Adrian
		SpriteSheet exitButton = new SpriteSheet(ImageLoader.loadImage("/textures/Buttons/QuitButton.png"));//Added by Adrian
		SpriteSheet startButton = new SpriteSheet(ImageLoader.loadImage("/textures/Buttons/StartButton.png"));//Added by Adrian
		SpriteSheet exitButtonYellow = new SpriteSheet(ImageLoader.loadImage("/textures/Buttons/QuitButtonYellow.png"));//Added by Adrian
		player = sheet.crop(247, 84, 99, 75);
		enemy = sheet.crop(144, 156, 103, 84);
		laser = sheet.crop(858, 230, 9, 54);
		gameBackround = ImageLoader.loadImage("/textures/black.png");
		menuBackground = ImageLoader.loadImage("/textures/Backgrounds/retroSciFi.jpg");//Added by Adrian
		gameOverBackground = ImageLoader.loadImage("/textures/Backgrounds/GameOverScreen.png");//Added by Adrian
		
		//Added by Adrian
		btn_start = new BufferedImage[2];
		btn_start[0] = startButton.crop(50, 40, 339, 129);
		btn_start[1] = startButton.crop(50, 40, 339, 129);
		
		btn_restart = new BufferedImage[2];
		btn_restart[0] = blueRestart.crop(0, 0, 348, 145);
		btn_restart[1] = greenRestart.crop(0, 0, 348, 145);
		
		btn_exit = new BufferedImage[2];
		btn_exit[0] = exitButton.crop(30, 30, 266, 92);
		btn_exit[1] = exitButtonYellow.crop(30, 30, 266, 92);
		// In the /game/backround folder I added GameOverBackground, MainMenuBackground, MenuBackground, OverBackground
		// I also added in a method that creates a hovering effect when the mouse is over the quit and restart buttons.
	}

}