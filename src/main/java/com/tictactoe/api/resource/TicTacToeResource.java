package com.tictactoe.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tictactoe.api.util.StringUtil;
import com.tictactoe.api.util.TicTacToeUtil;

@Path("/api/tictactoe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicTacToeResource {

	private String[][] currentBoard;
	private String currentState;
	
	public TicTacToeResource(String defaultState) {
		this.currentBoard = new String[][]{{"","",""},{"","",""},{"","",""}};
		this.currentState = defaultState;
	}

	
	@POST
	@Path("/xs")
	public Response xTurn(String data) {
		System.out.println("TicTacToeResource.xTurn() : " + data);
		
		String[][] board = StringUtil.getBoard(data);
		StringUtil.printBoard(board);
		
		if (TicTacToeUtil.isWinner(board, "O")) {
			currentState = "You win!";
		}
		else if (TicTacToeUtil.isCatsGame(board)) {
			currentState = "Cat's game";
		}
		else {
			board = TicTacToeUtil.makeMove(board, "X");
			
			if (TicTacToeUtil.isWinner(board, "X"))
				currentState = "I win!";
			else if (TicTacToeUtil.isCatsGame(board))
				currentState = "Cat's game";
			else
				currentState = "Your turn";
		}

		currentBoard = board;
		
		return Response.status(201).entity(new TicTacToeResponse(currentBoard, currentState)).build();
	}
	
	@POST
	@Path("/os")
	public Response oTurn(String data) {
		System.out.println("TicTacToeResource.xTurn() : " + data);
		
		String[][] board = StringUtil.getBoard(data);
		StringUtil.printBoard(board);
		
		if (TicTacToeUtil.isWinner(board, "X")) {
			currentState = "You win!";
		}
		else if (TicTacToeUtil.isCatsGame(board)) {
			currentState = "Cat's game";
		}
		else {
			board = TicTacToeUtil.makeMove(board, "O");
			
			if (TicTacToeUtil.isWinner(board, "O"))
				currentState = "I win!";
			else if (TicTacToeUtil.isCatsGame(board))
				currentState = "Cat's game";
			else
				currentState = "Your turn";
		}

		currentBoard = board;
		
		return Response.status(201).entity(new TicTacToeResponse(currentBoard, currentState)).build();
	}
	
	/*
	@GET
	public TicTacToeResponse getBoard() {
		return new TicTacToeResponse(currentBoard, currentState);
	}
	*/
}