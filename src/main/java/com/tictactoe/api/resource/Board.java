package com.tictactoe.api.resource;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Board {
/*
	private List<String> board;
	
	public Board(List<String> board) {
		this.board = board;
	}

	@JsonProperty
	public List<String> getBoard() {
		return board;
	}

	@JsonProperty
	public void setBoard(List<String> board) {
		this.board = board;
	}
	*/
	@NotNull
	private String[][] board;

	public Board(String[][] board) {
//		super();
		this.board = board;
	}
	
	@JsonProperty
	public String[][] getBoard() {
		return board;
	}

	@JsonProperty
	public void setBoard(String[][] board) {
		this.board = board;
	}



}