package graphics;
import java.awt.image.BufferedImage;

public class assets {
	
	
	private static final int widthP = 48 , heightP = 48; //width for the player
	private static final int width = 64 , height = 64; //width for the Lava
	
	public static BufferedImage Blank,Tree,Chest , Crate, FinishFlag, Grass, TabDown, TabUp, TabLeft, TabRight, Dirt,background,player_jump_right,player_jump_left,player_fall_left,player_fall_right;
	public static BufferedImage[] 	player_idle_right ,player_run_right ,player_climb ,player_damaged_right ,player_death_right 
									,player_push_right
									,player_idle_left ,player_run_left ,player_damaged_left ,player_death_left 
									,player_push_,Lava,LavaSurface;
	
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_idle_right.png"));
		player_idle_right = new BufferedImage[4];
		player_idle_right[0] = sheet.crop(0,0,widthP,heightP);
		player_idle_right[1] = sheet.crop(widthP,0,widthP,heightP);
		player_idle_right[2] = sheet.crop(widthP * 2,0,widthP,heightP);
		player_idle_right[3] = sheet.crop(widthP * 3,0,widthP,heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_idle_left.png"));
		player_idle_left = new BufferedImage[4];
		player_idle_left[3] = sheet.crop(0,0,widthP,heightP);
		player_idle_left[2] = sheet.crop(widthP,0,widthP,heightP);
		player_idle_left[1] = sheet.crop(widthP * 2,0,widthP,heightP);
		player_idle_left[0] = sheet.crop(widthP * 3,0,widthP,heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_run_right.png"));
		player_run_right = new BufferedImage[6];
		player_run_right[0] = sheet.crop(0, 0, widthP, heightP);
		player_run_right[1] = sheet.crop(widthP, 0, widthP, heightP);
		player_run_right[2] = sheet.crop(widthP * 2, 0, widthP, heightP);
		player_run_right[3] = sheet.crop(widthP * 3, 0, widthP, heightP);
		player_run_right[4] = sheet.crop(widthP * 4, 0, widthP, heightP);
		player_run_right[5] = sheet.crop(widthP * 5, 0, widthP, heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_run_left.png"));
		player_run_left = new BufferedImage[6];
		player_run_left[5] = sheet.crop(0, 0, widthP, heightP);
		player_run_left[4] = sheet.crop(widthP, 0, widthP, heightP);
		player_run_left[3] = sheet.crop(widthP * 2, 0, widthP, heightP);
		player_run_left[2] = sheet.crop(widthP * 3, 0, widthP, heightP);
		player_run_left[1] = sheet.crop(widthP * 4, 0, widthP, heightP);
		player_run_left[0] = sheet.crop(widthP * 5, 0, widthP, heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_climb.png"));
		player_climb = new BufferedImage[6];
		player_climb[0] = sheet.crop(0,0,widthP,heightP);
		player_climb[1] = sheet.crop(widthP,0,widthP,heightP);
		player_climb[2] = sheet.crop(widthP * 2,0,widthP,heightP);
		player_climb[3] = sheet.crop(widthP * 3,0,widthP,heightP);
		player_climb[4] = sheet.crop(widthP * 4,0,widthP,heightP);
		player_climb[5] = sheet.crop(widthP * 5,0,widthP,heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_damaged_right.png"));
		player_damaged_right = new BufferedImage[3];
		player_damaged_right[0] =sheet.crop(0, 0, widthP, heightP); 
		player_damaged_right[1] =sheet.crop(widthP, 0, widthP, heightP); 
		player_damaged_right[2] =sheet.crop(widthP * 2, 0, widthP, heightP); 

		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_death_right.png"));
		player_death_right = new BufferedImage[6];
		player_death_right[0] = sheet.crop(0, 0, widthP, heightP);
		player_death_right[1] = sheet.crop(widthP, 0, widthP, heightP);
		player_death_right[2] = sheet.crop(widthP * 2, 0, widthP, heightP);
		player_death_right[3] = sheet.crop(widthP * 3, 0, widthP, heightP);
		player_death_right[4] = sheet.crop(widthP * 4, 0, widthP, heightP);
		player_death_right[5] = sheet.crop(widthP * 5, 0, widthP, heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_death_left.png"));
		player_death_left = new BufferedImage[6];
		player_death_left[5] = sheet.crop(0, 0, widthP, heightP);
		player_death_left[4] = sheet.crop(widthP, 0, widthP, heightP);
		player_death_left[3] = sheet.crop(widthP * 2, 0, widthP, heightP);
		player_death_left[2] = sheet.crop(widthP * 3, 0, widthP, heightP);
		player_death_left[1] = sheet.crop(widthP * 4, 0, widthP, heightP);
		player_death_left[0] = sheet.crop(widthP * 5, 0, widthP, heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_jump_right.png"));
		player_jump_right = sheet.crop(widthP * 2, 0,widthP, heightP);
		player_fall_right = sheet.crop(widthP * 3, 0,widthP, heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_jump_left.png"));
		player_jump_left = sheet.crop(widthP * 3, 0,widthP, heightP);
		player_fall_left = sheet.crop(widthP * 2, 0,widthP, heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player/Player_push_right.png"));
		player_push_right = new BufferedImage[6];
		player_push_right[0] = sheet.crop(0,0,widthP,heightP);
		player_push_right[1] = sheet.crop(widthP,0,widthP,heightP);
		player_push_right[2] = sheet.crop(widthP * 2,0,widthP,heightP);
		player_push_right[3] = sheet.crop(widthP * 3,0,widthP,heightP);
		player_push_right[4] = sheet.crop(widthP * 4,0,widthP,heightP);
		player_push_right[5] = sheet.crop(widthP * 5,0,widthP,heightP);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Lava.png"));
		Lava = new BufferedImage[2];
		Lava[0] = sheet.crop(0, 0, width, height);
		Lava[1] = sheet.crop(width, 0, width, height);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/LavaSurface.png"));
		LavaSurface = new BufferedImage[2];
		LavaSurface[0] = sheet.crop(0, 0, width, height);
		LavaSurface[1] = sheet.crop(width, 0, width, height);
		
		Chest = ImageLoader.loadImage("/textures/chest.png");
		Crate = ImageLoader.loadImage("/textures/crate.png");
		FinishFlag= ImageLoader.loadImage("/textures/finish_flag.png");
		Grass = ImageLoader.loadImage("/textures/gras.png");
		TabDown = ImageLoader.loadImage("/textures/tab_down.png");
		TabUp = ImageLoader.loadImage("/textures/tab_up.png");
		TabLeft = ImageLoader.loadImage("/textures/tab_left.png");
		TabRight = ImageLoader.loadImage("/textures/tab_right.png");
		Dirt = ImageLoader.loadImage("/textures/dirt.png");
		Blank = ImageLoader.loadImage("/textures/Blank.png");
		background = ImageLoader.loadImage("/textures/background.png");
		Tree = ImageLoader.loadImage("/textures/tree.png");
	}
}
