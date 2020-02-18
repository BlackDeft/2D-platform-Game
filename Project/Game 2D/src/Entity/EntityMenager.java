package Entity;

import java.awt.Graphics;
import java.util.ArrayList;

import Creatures.Player;
import main.Handler;

public class EntityMenager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	public EntityMenager(Handler handler,Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		for (int i = 0; i<entities.size();i++) {
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i<entities.size();i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
	}
	public void addEntity(Entity e) {
		entities.add(e);
	}
	public ArrayList<Entity> getEntities(){
		return entities;
	}
	
	public Handler getHandler() {
		return handler;
	}
}
