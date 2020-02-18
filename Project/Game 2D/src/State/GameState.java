package State;

import java.awt.Graphics;

import main.Handler;
import world.World;

public class GameState extends State{

	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler,"res/worlds/world.lvl");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
