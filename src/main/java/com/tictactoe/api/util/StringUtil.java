package com.tictactoe.api.util;

public class StringUtil {

	public static String[][] getBoard(String data) {
		System.out.println("data: " + data);
		data = data.replace("{\"board\":", "");	//	{\"board\":
//		System.out.println("data: " + data);
		data = ((data.replace("[","")).replace("]", "")).replace("}", "");
//		System.out.println("data: " + data);
		String[] elements = data.split(",");
		
//		for (String s : elements) {
//			System.out.println(s);
//		}
		
//		String[][] board = loadBoard(elements);
		
//		System.out.println("Printing board...");
//		for (int row=0; row<board.length; row++) {
//			for (int column=0; column<board[row].length; column++) {
//				System.out.print(board[row][column] + "|");
//			}
//			System.out.println();
//		}
		
		String[][] board = new String[3][3];
		int cnt = 0;
		String element = "";
		
		for (int row=0; row<board.length; row++) {
			for (int column=0; column<board[row].length; column++) {
				if (elements[cnt].equals("\"\""))
					element = "";
				else
					element = elements[cnt].replace("\"","");
				
				board[row][column] = element;
				cnt++;
			}
		}
		return board;
	}
	
	public static void printBoard(String[][] board) {
		System.out.println("Printing board...");
		for (int row=0; row<board.length; row++) {
			for (int column=0; column<board[row].length; column++) {
				System.out.print(board[row][column] + "|");
			}
			System.out.println();
		}
	}
}
