package com.app.models;

import java.util.ArrayList;
import java.util.List;

import com.app.enums.Symbol;

public class Board {
	private final List<List<Block>> board; 
	private final int size;
	public Board(int size) {
		this.size = size;
		this.board = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			List<Block> row = new ArrayList<>();
			for(int j = 0; j < size; j++) {
				row.add(new Block(Symbol.EMPTY));
			}
			board.add(row);
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isAvailable(int row, int col) {
		return board.get(row).get(col).getPlayerSymbol() == Symbol.EMPTY;
	}
	
	public void add(int row, int col, Player player) {
		Block block = new Block(player.getSymbol());
		board.get(row).set(col, block);
	}
	
	public boolean checkForWin(int row, int col, Symbol playerSymbol) {
		int rowCount = 0;
		int colCount = 0;
		int diagCount = 0;
		int crossDiagCount = 0;
		for(int i = 0; i < size; i++) {
			// Check Row
			if(board.get(row).get(i).getPlayerSymbol() == playerSymbol)
				rowCount++;
			// Check Column
			if(board.get(i).get(col).getPlayerSymbol() == playerSymbol)
				colCount++;
			// Check Main Diagonal
			if(row == col && (board.get(i).get(i).getPlayerSymbol() == playerSymbol))
				diagCount++;
			// Check Cross Diagonal
			if((row + col == size - 1) && (board.get(i).get(size-1-i).getPlayerSymbol() == playerSymbol))
				crossDiagCount++;
		}
		
		return rowCount == size || colCount == size || diagCount == size || crossDiagCount == size;
		
	}
}
