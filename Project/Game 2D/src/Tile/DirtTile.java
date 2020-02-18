package Tile;

import graphics.assets;

public class DirtTile extends Tile{

	public DirtTile( int id) {
		super(assets.Dirt , id);
	}
	
	public boolean isSolid() {
		return true;
	}

}
