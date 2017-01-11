package game;

import java.util.Scanner;

public class Game {
	private Board board;
	private Player playerX, playerO, currentPlayer;
	private int row, col, option, turn, gameNr;
	private char choice;
	private boolean running;
	private Scanner sc = new Scanner(System.in);
	
	public Game() {
		board = new Board();
		setupGame();	
		play();		
	}
	
	public void setupGame() {
		System.out.println("==============");
		System.out.println(" Tic-Tac-Toe! ");
		System.out.println("==============");
		System.out.println("1. Player vs Player");
		System.out.println("2. Player vs Computer");
		option = sc.nextInt();
		sc.nextLine();
		
		if (option == 1) {
			System.out.println("Player 1 name: (X)");
			String nameX = sc.nextLine();
			playerX = new Player('X', nameX);
		
			System.out.println("Player 2 name: (O)");
			String nameO = sc.nextLine();
			playerO = new Player('O', nameO);
		}
		else if (option == 2) {
			System.out.println("Player name: (X)");
			String nameX = sc.nextLine();
			playerX = new Player('X', nameX);
			playerO = new Computer('O', "Easy CPU");
		}
		else {
			System.out.println("Wrong input!");
		}
	}
	
	public void play() {
		gameNr++;
		checkScore();	
		board.printBoard();	
		
		running = true;
		
		while(running){	
			turn++;	
			checkWho();	
			
			System.out.println(currentPlayer.getName() +"'s (" +currentPlayer.getSymbol() +") turn.");
			
			row = currentPlayer.getRow();
			col = currentPlayer.getCol();
			
			if (board.board[row][col] == '_') {
				board.board[row][col] = currentPlayer.getSymbol();
			} else {
				System.out.println("Spot already taken! Choose another one!");
				turn--;
			}
			
			checkScore();
			board.printBoard();
			
			if (checkWinner(row, col)) {
				running = false;
			}
			else if (board.full()) {
				running = false;
			}
		}
		board.clearBoard();
		play();
	}
	
	
	public void checkWho() {
		if(turn % 2 == 0) {
			currentPlayer = playerO;
		}
		else {
			currentPlayer = playerX;
		}
	}
	
	public void addScore() {
		System.out.println("==============");
		System.out.println("Winner is " + currentPlayer.getName() +"!");
		System.out.println("==============");
		
		currentPlayer.setScore();
	}
	
	public void checkScore() {
		System.out.println(playerX.getName() +" vs " + playerO.getName() +": " +playerX.getScore() +" - " +playerO.getScore() +" (Game " +gameNr +")");
	}
	
	public boolean checkWinner(int row, int col) {
		choice = currentPlayer.getSymbol();
		
		if(board.board[0][col] == board.board[1][col] && board.board[0][col] == board.board[2][col]) {
			addScore();
			return true;
		}
		if(board.board[row][0] == board.board[row][1] && board.board[row][0] == board.board[row][2]) {
			addScore();
			return true;
		}
		if (choice == board.board[0][0] && choice == board.board[1][1] && choice == board.board[2][2]) {
			addScore();
			return true;
		}
		if (choice == board.board[0][2] && choice == board.board[1][1] && choice == board.board[2][0]) {
			addScore();
			return true;
		}

		return false;
	}
	
//[0,0] [0,1] [0,2]				[1] [2] [3]
//[1,0] [1,1] [1,2]		==		[4] [5] [6]
//[2,0] [2,1] [2,2]				[7] [8] [9]
	
}