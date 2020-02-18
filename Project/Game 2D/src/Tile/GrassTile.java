
package Tile;

import graphics.assets;

public class GrassTile extends Tile{

	public GrassTile( int id) {
		super(assets.Grass, id);
		
	}
	
	public boolean isSolid() {
		return true;
	}
	
}
