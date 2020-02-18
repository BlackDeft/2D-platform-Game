
package Tile;

import graphics.assets;

public class CrateTile extends Tile{

	public CrateTile( int id) {
		super(assets.Crate, id);
		
	}
	
	public boolean isSolid() {
		return true;
	}
	
}