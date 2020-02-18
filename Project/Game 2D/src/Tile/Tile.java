package Tile;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static final int TILEWIDTH = 100, TILEHEIGHT = 100;
	
	
	public static Tile[] tiles = new Tile[256];
	public static Tile BlankTile = new BlankTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile dirtTile = new DirtTile(2);
	public static Tile tabUpTile = new TabUpTile(3);
	public static Tile tabDownTile = new TabDownTile(4);
	public static Tile tabLeftTile = new TabLeftTile(5);
	public static Tile tabRightTile = new TabRightTile(6);	
	public static Tile crateTile = new CrateTile(9);
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture,int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y){
		
		g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
		
	}
	
	public boolean isSolid() {
		return false;
	}
	public int getId() {
		return id;
	}

}
