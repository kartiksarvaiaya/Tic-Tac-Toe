package com.app.models;

import com.app.enums.Symbol;

public class Player {
	private final int id;
	private final String name;
	private final Symbol symbol;
	public Player(int id, String name, Symbol symbol) {
		this.id = id;
		this.name = name;
		this.symbol = symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public Symbol getSymbol() {
		return symbol;
	}
}
