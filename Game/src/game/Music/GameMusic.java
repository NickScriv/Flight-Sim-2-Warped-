package game.Music;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameMusic {
	
	private static long time;
	private static AudioInputStream audioInput;
	private static Clip clip;

	public static void startMusic(String musicLocation)
	{
	
			try
			{
				File musicPath = new File(musicLocation);
				
				if(musicPath.exists())
				{
					audioInput = AudioSystem.getAudioInputStream(musicPath);  
					clip = AudioSystem.getClip();
					clip.open(audioInput);
					
					clip.start();
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					Thread.sleep(10);
					
					
				}
				else
				{
					System.out.println("File not found");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}
	
	public static void pauseMusic()
	{
		
		time = clip.getMicrosecondPosition();
		clip.stop();
			
	}
	
	public static void resumeMusic()
	{
		clip.setMicrosecondPosition(time);
		clip.start();	
	}
	
	

}