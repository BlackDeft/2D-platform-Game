package StaticEntity;

import java.awt.Graphics;
import Tile.Tile;
import main.Handler;
import graphics.assets;

public class Tree extends StaticEntity{
	public Tree(Handler handler,float  x , float y ) {
		super(handler, x, y, Tile.TILEWIDTH,Tile.TILEHEIGHT * 2 );
	}


	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(assets.Tree, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
		
	}

	public boolean isSolid() {
		return false;
	}

}
