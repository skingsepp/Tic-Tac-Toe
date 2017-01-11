package game;

import java.util.Scanner;

public class Player {
	private Scanner sc = new Scanner(System.in);
	private String name;
	private char symbol;
	private int score;
	private int row, col;
	
	public Player(char symbol, String name) {
		this.symbol = symbol;
		this.name = name;
		score = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public int getScore() {
		return score;
	}
	
	public int setScore() {
		score++;
		return score;
	}
	
	public int getRow() {
		System.out.println("Choose a row (1-3): ");
		row = sc.nextInt() - 1;
		
		while (row < 0 || row > 2) {
			System.out.println("Wrong input! Only input 1-3");
			row = sc.nextInt() - 1;
		}
		
		return row;
	}
	
	public int getCol() {
		System.out.println("Choose a column (1-3): ");
		col = sc.nextInt() - 1;
		
		while (col < 0 || col > 2) {
			System.out.println("Wrong input! Only input 1-3");
			col = sc.nextInt() - 1;
		}
	
		return col;
	}
}
