package main;

import world.World;
import game.Game;
import graphics.GameCamera;
import input.KeyMenager;

public class Handler{
 private Game game;
 private World world;
 
 public Handler(Game game) {
	 this.game = game;
 }
 
 public GameCamera getGameCamera() {
	 return game.getGameCamera();
	 }
 
 public KeyMenager getKeyMenager() {
	 return game.getKeyMenager();
 }
 public int getWidth() {
	 return game.getWidth();
 }
 
 public int getHeight() {
	 return game.getHeight();
 }

public Game getGame() {
	return game;
}

public void setGame(Game game) {
	this.game = game;
}

public World getWorld() {
	return world;
}

public void setWorld(World world) {
	this.world = world;
}
}
