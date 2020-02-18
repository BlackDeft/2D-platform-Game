package StaticEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Tile.Tile;
import graphics.assets;
import main.Handler;

public class Crate extends StaticEntity{
	private float pushPower = 2;
	private Rectangle pushX,pushY;
	public static boolean PushingL=false;
	public static boolean PushingR=false;;
	public Crate(Handler handler, float x, float y) {
		super(handler, x, y,50,50);
		pushX = new Rectangle(( int )x+25,( int )y,30,30);
		pushY = new Rectangle(( int )x-5,( int )y,30,30);
	}
	
	private float gravity = 5;
	@Override
	public void tick() {
		fall();
		pushX.x=(int) x+25;
		pushY.x=(int) x-5;
		pushY.y=(int) y+10;
		pushX.y=(int) y+10;

	}
	private void fall() {
		int ty = (int) (y + gravity + bounds.y + bounds.height) / Tile.TILEHEIGHT;
		
		if(!collision( (int) (x+bounds.x) / Tile.TILEWIDTH,ty ) &&
				!collision( (int) (x+bounds.x + bounds.width) / Tile.TILEWIDTH,ty ) && !checkEntityCollisions(0f,gravity) )
		{
			y+=gravity;
		}
		else y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
	}
	public void doOnTouch()
	{
		if(pushY.x < handler.getWorld().getEntityManager().getPlayer().getX() + handler.getWorld().getEntityManager().getPlayer().getWidth() &&
				pushY.x + pushY.width > handler.getWorld().getEntityManager().getPlayer().getX() &&
				pushY.y < handler.getWorld().getEntityManager().getPlayer().getY() + handler.getWorld().getEntityManager().getPlayer().getHeight() &&
				pushY.y + pushY.height > handler.getWorld().getEntityManager().getPlayer().getY()) {
			pushRight();
		}
		else if (pushX.x < handler.getWorld().getEntityManager().getPlayer().getX() + handler.getWorld().getEntityManager().getPlayer().getWidth() &&
		pushX.x + pushX.width > handler.getWorld().getEntityManager().getPlayer().getX() &&
		pushX.y < handler.getWorld().getEntityManager().getPlayer().getY() + handler.getWorld().getEntityManager().getPlayer().getHeight() &&
		pushX.y + pushX.height > handler.getWorld().getEntityManager().getPlayer().getY()) {
			pushLeft();
		}
	}
	private void pushLeft() {
		int tx = (int) (x+pushPower+bounds.x) / Tile.TILEWIDTH;
		if(!collision(tx,(int) (y+bounds.y)/Tile.TILEHEIGHT) &&
				!collision(tx,(int)(y+bounds.y + bounds.height) / Tile.TILEHEIGHT))
		{
			x-=pushPower;
			PushingL=true;
		}
	}
	private void pushRight() {
		int tx = (int) (x+pushPower+bounds.x + bounds.width) / Tile.TILEWIDTH;
		if(!collision(tx,(int) (y+bounds.y)/Tile.TILEHEIGHT) && !collision(tx,(int)(y+bounds.y + bounds.height) / Tile.TILEHEIGHT))
			
			{
			
			x+=pushPower;
			}PushingR = true;
	}
	protected boolean collision(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(assets.Crate, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),50,50,null);

	}

	
}
