package State;
import java.awt.Graphics;
import graphics.assets;
import main.Handler;

public class MenuState extends State{
	
	public MenuState(Handler handler) {
		super(handler);
		
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(assets.Grass,0,0,null);
		
	}

}
