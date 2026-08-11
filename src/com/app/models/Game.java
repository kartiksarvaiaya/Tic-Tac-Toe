package com.app.models;

public class Game {
	private final Board board;
	private final Player player1;
	private final Player player2;
	private Player winner;
	private Player currentPlayer;
	private int moves;
	
	public Game(Board board, Player player1, Player player2) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		this.currentPlayer = player1;
	}
	
	public boolean makeMove(int row, int col){
		if(!board.isAvailable(row, col))
			return false;
		board.add(row, col, currentPlayer);
		moves++;
		
		if(board.checkForWin(row, col, currentPlayer.getSymbol())) {
			winner = currentPlayer;
		}
		else switchTurn();
		return true;
	}
    private void switchTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
    public boolean isGameOver() {
        return winner != null || moves == (board.getSize() * board.getSize());
    }

    public boolean isDraw() {
        return winner == null && moves == (board.getSize() * board.getSize());
    }

    public Player getWinner() {
        return winner;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
	
}
