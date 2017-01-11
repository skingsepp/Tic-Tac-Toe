package game;

import java.util.Random;

public class Computer extends Player {
	private Random rand = new Random();
	private int row, col;
	
	public Computer(char symbol, String name) {
		super(symbol, name);
	}
	
	@Override
	public int getRow() {
		row = rand.nextInt(3);
		return row;
	}
	
	@Override
	public int getCol() {
		col = rand.nextInt(3);
		return col;
	}
}
