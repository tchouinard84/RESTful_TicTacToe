package com.tictactoe.api.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicTacToeResponse {

	private String[][] board;
	private String state;
	
	public TicTacToeResponse(String[][] board, String state) {
		this.board = board;
		this.state = state;
	}
	
	@JsonProperty
	public String[][] getBoard() {
		return board;
	}
	@JsonProperty
	public void setBoard(String[][] board) {
		this.board = board;
	}
	@JsonProperty
	public String getState() {
		return state;
	}
	@JsonProperty
	public void setState(String state) {
		this.state = state;
	}
}
