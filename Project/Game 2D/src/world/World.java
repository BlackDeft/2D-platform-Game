package world;
import java.awt.Graphics;

import Creatures.Player;
import Entity.EntityMenager;
import StaticEntity.Crate;
import StaticEntity.LavaSurface;
import StaticEntity.Tree;
import Tile.Tile;
import graphics.assets;
import main.Handler;
import utils.utils;
public class World {
	private Handler handler;
	private int width, height;
	private int spawnX , spawnY;
	private int tiles[][];
	private EntityMenager entityManager;
	
	public World(Handler handler,String path) {
		this.handler = handler;
		entityManager = new EntityMenager(handler,new Player(handler,100 ,100));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int	xEnd = (int) Math.min(width , (handler.getGameCamera().getxOffset() + handler.getWidth()) /Tile.TILEWIDTH + 1);
		int	yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int	yEnd = (int) Math.min(height ,(handler.getGameCamera().getyOffset() + handler.getHeight()) /Tile.TILEHEIGHT + 1);
		
		g.drawImage(assets.background, 0, 0,handler.getWidth(),handler.getHeight(),null);
		
		for(int x = xStart;x < xEnd;x++)
		{
			for(int y = yStart;y < yEnd;y++)
			{
				getTile(x,y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) ( y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		entityManager.render(g);
	}
	public Tile getTile(int x,int y ) {
		if(x < 0 || y < 0 || x >= width || y >= height )
			return Tile.grassTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = utils.parseInt(tokens[0]);
		height = utils.parseInt(tokens[1]);
		spawnX = utils.parseInt(tokens[2]);
		spawnY = utils.parseInt(tokens[3]);
		
		//LOAD WORLD
		tiles = new int[width][height];
		for (int x = 0;x< width;x++)
		{
			for(int y = 0;y<height;y++) {
				tiles[x][y] = utils.parseInt(tokens[(x + y * width) + 4]);
			}
		
		}
		
		//LOAD ENTITY
		int index = 0;
	do {
		if(utils.parseInt(tokens[4 + width * height + index]) == 1) {
			entityManager.addEntity(new Tree(handler,utils.parseInt(tokens[5 + width * height + index]),utils.parseInt(tokens[6 + width * height + index])));
		}
			else if (utils.parseInt(tokens[4 + width * height + index]) == 2) {
				entityManager.addEntity(new LavaSurface(handler,utils.parseInt(tokens[5 + width * height + index]),utils.parseInt(tokens[6 + width * height + index])));
			}
			else if (utils.parseInt(tokens[4 + width * height + index]) == 3)
			{
				entityManager.addEntity(new Crate(handler,utils.parseInt(tokens[5 + width * height + index]),utils.parseInt(tokens[6 + width * height + index])));
			}
				
		index++;
	}while(!tokens[ 4 + width * height + index].endsWith("end"));

	}
	
	public EntityMenager getEntityManager() {
		return entityManager;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
