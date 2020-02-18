package Creatures;
import main.Handler;
import Entity.Entity;
import Tile.Tile;
public abstract class Creature extends Entity{

	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 48, DEFAULT_CREATURE_HEIGHT = 48;
	


	protected float speed;
	protected float xMove, yMove;
	protected float lastPosition;
	protected float jumpPower;
	protected float jumpedFrom;
	protected float gravity;
	
	protected int health;
	
	protected boolean Alive = true;
	protected boolean falling = true;
	protected boolean canJump;
	protected boolean jumping = false;
	
	
	public Creature(Handler handler,float x, float y,int width,int height) {
		super( handler,x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		gravity = 4;
		jumpPower = 120;
	}
	public void killCreature() {
		Alive = false;
	}
	public void move() {
		if(Alive) {
		if(!checkEntityCollisions(xMove,0f))
		moveX();
		moveY();			
		}
	}
	public void moveX() {
		if(xMove > 0)
		{
			int tx = (int) (x+xMove+bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collision(tx,(int) (y+bounds.y)/Tile.TILEHEIGHT) && !collision(tx,(int)(y+bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			}
			else {
			//	x = tx*Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if (xMove < 0 && x >=0)
		{
			int tx = (int) (x+xMove+bounds.x) / Tile.TILEWIDTH;
			
			if(!collision(tx,(int) (y+bounds.y)/Tile.TILEHEIGHT) &&
					!collision(tx,(int)(y+bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			}
			else
			{
				//x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH + bounds.x;
			}

		}
	}
	
	public void moveY() {

		if(canJump)
		{
			jumpedFrom = y;
			int ty = (int) (y + gravity + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collision( (int) (x+bounds.x) / Tile.TILEWIDTH,ty ) &&
					!collision( (int) (x+bounds.x + bounds.width) / Tile.TILEWIDTH,ty ) && !checkEntityCollisions(0f,gravity))
			{
				falling=true;
			}
		}
			
		if(jumping && !falling)			
		{

			canJump = false;
				
			int ty = (int) (y + gravity + bounds.y) / Tile.TILEHEIGHT;
			
			float height = y - jumpedFrom;
				if(height > -jumpPower)
				{
						if(!collision( (int) (x+bounds.x) / Tile.TILEWIDTH,ty ) &&
							!collision( (int) (x+bounds.x + bounds.width) / Tile.TILEWIDTH,ty ))
							y-=gravity;
						else 
							{
						//	y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
							falling = true;
							jumping = false;
							}
				}
				else 
				{
			//	y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
				falling = true;
				jumping = false;
				}
	
				
		}
		else if (falling)
		{
			
			int ty = (int) (y + gravity + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collision( (int) (x+bounds.x) / Tile.TILEWIDTH,ty ) &&
					!collision( (int) (x+bounds.x + bounds.width) / Tile.TILEWIDTH,ty ) && !checkEntityCollisions(0f,gravity) )
			{
				y+=gravity;
			}
			else 
			{
				//y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
				falling = false;
				canJump = true;
			}
			jumping = false;
				
		}
	}
	
	
	protected boolean collision(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	////Getters and Setters
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
