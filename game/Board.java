package game;

public class Board {
	private int table = 3;
	public char[][] board = new char[table][table];
	
	public Board() {
		clearBoard();
	}

	public void clearBoard() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				board[row][col] = '_';
			}
		}
	}

	public void printBoard() {
		for (int row = 0; row < board.length; row++) {
			System.out.println();
			for (int col = 0; col < board.length; col++) {
				if (col == 0) {
					System.out.print("| ");				
				}
				System.out.print(board[row][col] + " | ");
			}
		}
		System.out.println("\n");
	}
	
	public boolean full() {
		for(int row = 0 ; row < board.length ; row++) {
			for(int col = 0 ; col < board.length ; col++){
				if(board[row][col] == '_'){
					return false;
				}
				
			}
		}
		System.out.println("==============");
		System.out.println("= It's a TIE =");
		System.out.println("==============");
		return true;
	}
}
