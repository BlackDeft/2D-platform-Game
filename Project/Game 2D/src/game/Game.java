package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import State.GameState;
import State.MenuState;
import State.State;
import display.Display;
import game.Game;
import graphics.GameCamera;
import graphics.assets;
import input.KeyMenager;
import main.Handler;

public class Game implements Runnable{
	
	private Display display;
	private int width,height;
	public String title;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	
	private KeyMenager KeyMenager;
	
	private GameCamera gameCamera;
	
	private Handler handler;
	
	public Game(String title,int width,int height) {
		this.width = width;
		this.height = height;
		this.title=title;
		KeyMenager = new KeyMenager();
	}
	
	private void init() {
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(KeyMenager);
		assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
		

	}
	
	
	private void tick() {
		KeyMenager.tick();
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render() {
		bs = display.GetCanvas().getBufferStrategy();
		if(bs == null) {
			display.GetCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width,height);
		//draw here 
		
		if(State.getState() !=null)
			State.getState().render(g);
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		
		int fps = 60;
		
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >=1) {
			tick();
			render();
			delta--;
			}
			
			if (timer>=1000000000) {
			timer = 0;
			}
		}
	}
	
	public KeyMenager getKeyMenager() {
		return KeyMenager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}