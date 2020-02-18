package Creatures;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import StaticEntity.Crate;
import graphics.Animations;
import graphics.assets;
import main.Handler;


public class Player extends Creature{

	private Animations animIdleRight;
	private Animations animRunRight;
	private Animations animDeathRight;
	private Animations animPushRight;
	private Animations animIdleLeft;
	private Animations animRunLeft;
	private Animations animDeathLeft;
	
	private boolean faceRight = true;
	
	
	
	public Player(Handler handler ,float x, float y) {
		super(handler ,x, y,Creature.DEFAULT_CREATURE_HEIGHT ,Creature.DEFAULT_CREATURE_WIDTH);
		bounds.x = 15;
		bounds.y = 16;
		bounds.width = 15;
		bounds.height = 32;
		
		
		//Animations RIGHT
		animIdleRight = new Animations(170,assets.player_idle_right);
		animRunRight = new Animations(170,assets.player_run_right);
		animDeathRight = new Animations(170,assets.player_death_right);
		animPushRight = new Animations(170,assets.player_push_right);
		//Animations LEFT
		animIdleLeft = new Animations(170,assets.player_idle_left);
		animRunLeft = new Animations(170,assets.player_run_left);
		animDeathLeft = new Animations(170,assets.player_death_left);
		
	}

	@Override
	public void tick() {
		//Animations RIGHT ticks
		
		animIdleRight.tick();
		animRunRight.tick();
		animPushRight.tick();
		//Animations LEFT ticks
		animIdleLeft.tick();
		animRunLeft.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		
		if(handler.getKeyMenager().up)
			jumping = true;
		if(handler.getKeyMenager().left)
		{
			xMove = -speed;
			faceRight = false;
		}	
		if(handler.getKeyMenager().right)
		{
			xMove = speed;
			faceRight = true;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame() ,(int) (x -handler.getGameCamera().getxOffset()) ,(int) (y - handler.getGameCamera().getyOffset()) 
				,width,height,null);
		
		/*g.setColor(Color.red);
		g.fillRect(( int ) (x + bounds.x - handler.getGameCamera().getxOffset()),
				( int )(y + bounds.y - handler.getGameCamera().getyOffset()),
						bounds.width,bounds.height );*/
		//   COLISSION BOX ^^^^^ ////
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(faceRight) {	
			if(!Alive)
			{
				if(animDeathRight.index != 5)
				animDeathRight.tick();
				if(animDeathRight.index == 5)
					return assets.player_death_right[5];
				else 
					return animDeathRight.getCurrentFrame();
			}
			if(Crate.PushingR) {
				Crate.PushingR=false;
				return animPushRight.getCurrentFrame();
			}
			if(jumping)
			{
				return assets.player_jump_right;
			}
			if(falling)
			{
				return assets.player_fall_right;
			}
			if(xMove !=0)
			{
				return animRunRight.getCurrentFrame();
			}

			return animIdleRight.getCurrentFrame();
		}
		else
		{	
			if(!Alive)
			{
				if(animDeathLeft.index != 5)
				animDeathLeft.tick();
				if(animDeathLeft.index == 5)
					return assets.player_death_left[5];
				else 
					return animDeathLeft.getCurrentFrame();
			}
			if(jumping)
			{
				return assets.player_jump_left;	
			}
			if(falling)
			{
				return assets.player_fall_left;
			}
			if(xMove !=0)
			{
				return animRunLeft.getCurrentFrame();
			}

			return animIdleLeft.getCurrentFrame();
		}

			
		
	}
	

}
