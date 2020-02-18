package main;

import game.Game;

public class Main {
	
	static String filePath;
	
	public static void main(String[] args) {

		Game game = new Game("Title Game",1000,1000);
		game.start();
	}


}
