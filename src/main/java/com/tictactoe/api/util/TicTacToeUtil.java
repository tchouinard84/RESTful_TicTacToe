package com.tictactoe.api.util;

public class TicTacToeUtil {

	public static boolean isWinner(String[][] board, String team) {
		
		if (isHorizontalWinner(board, team))
			return true;
		if (isVerticalWinner(board, team))
			return true;
		if (isDiagonalWinner(board, team))
			return true;
		
		return false;
	}
	
	public static boolean isCatsGame(String[][] board) {
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j].equals(""))
					return false;
			}
		}
		return true;
	}
	
	public static String[][] makeMove(String[][] board, String team) {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j].equals("")) {
					board[i][j] = team;
					return board;
				}
			}
		}
		return board;
	}
	
	private static boolean isHorizontalWinner(String[][] board, String team) {
		int cnt = 0;
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j].equalsIgnoreCase(team))
					cnt++;
				else
					break;
			}
			
			if (cnt == 3)
				return true;
			
			cnt = 0;
		}
		
		return false;
	}
	private static boolean isVerticalWinner(String[][] board, String team) {
		int cnt = 0;
		int i = 0;
		
		for (int j=0; j<board[i].length; j++) {
			while(i<board.length) {
				if (board[i][j].equalsIgnoreCase(team))
					cnt++;
				else
					break;
				
				i++;
			}
			
			if (cnt == 3)
				return true;
			
			cnt = 0;
			i = 0;
		}
		
		return false;
	}
	private static boolean isDiagonalWinner(String[][] board, String team) {
		int cnt = 0;
		
		for (int i=0; i<board.length; i++) {
			if (board[i][i].equalsIgnoreCase(team)) {
				cnt++;
			}
			else
				break;

			if (cnt == 3)
				return true;
		}
		
		cnt = 0;
		if (board[2][0].equalsIgnoreCase(team)) {
			if (board[1][1].equalsIgnoreCase(team)) {
				if (board[0][2].equalsIgnoreCase(team))
					return true;
			}
		}
		
		return false;
	}
	

}
