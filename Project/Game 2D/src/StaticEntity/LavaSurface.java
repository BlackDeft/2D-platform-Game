package StaticEntity;


import java.awt.Graphics;

import Tile.Tile;
import graphics.Animations;
import graphics.assets;
import main.Handler;

public class LavaSurface extends StaticEntity{
	private Animations animLavaSurface;
	public LavaSurface(Handler handler,float  x , float y ) {
		super(handler, x, y, Tile.TILEWIDTH,Tile.TILEHEIGHT * 2 );
		animLavaSurface = new Animations(370,assets.LavaSurface);
		
		bounds.x = 0;
		bounds.y = 70;
		bounds.width = 100;
		bounds.height = 100;
	}


	@Override
	public void tick() {
		// TODO Auto-generated method stub
		animLavaSurface.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animLavaSurface.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
	}
	
	public void killPlayer() {
		
	}
	
	protected void doOnTouch() {
		handler.getWorld().getEntityManager().getPlayer().killCreature();
	}
}
