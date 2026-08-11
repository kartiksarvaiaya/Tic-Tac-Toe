package com.app.models;

import com.app.enums.Symbol;

public class Block {
	private Symbol symbol;
	
	public Block(Symbol symbol) {
		this.symbol = symbol;
	}
	public Symbol getPlayerSymbol() {
		return symbol;
	}
	
}
