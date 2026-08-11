package com.app;

import java.util.Scanner;

import com.app.enums.Symbol;
import com.app.models.Board;
import com.app.models.Game;
import com.app.models.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1 = new Player(1, "Kartik", Symbol.X);
		Player player2 = new Player(2, "Monu", Symbol.O);
		
		System.out.println("Please enter size of the board: ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		Board board = new Board(size);
		Game game = new Game(board, player1, player2);
		
		while(!game.isGameOver()) {
			Player currentPlayer = game.getCurrentPlayer();
			System.out.println(currentPlayer.getName() + " Please play your move");
			System.out.println("Enter the row and col where you want to place your symbol");
			int row = sc.nextInt();
			int col = sc.nextInt();
			if(!game.makeMove(row, col))
				System.out.println("Position filled please retry");
		}
		if(game.isDraw()) 
			System.out.println("Game is Draw");
		else 
			System.out.println(game.getWinner().getName() + " have won the game");
	}

}
