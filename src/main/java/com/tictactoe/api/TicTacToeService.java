package com.tictactoe.api;

import com.tictactoe.api.config.TicTacToeServiceConfiguration;
import com.tictactoe.api.resource.TicTacToeResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TicTacToeService extends Service<TicTacToeServiceConfiguration> {

	public static void main(String[] args) throws Exception {
		new TicTacToeService().run(new String[] { "server", "src/main/resources/tictactoe-service.yml" });
	}

	@Override
	public void initialize(Bootstrap<TicTacToeServiceConfiguration> bootstrap) {
		bootstrap.setName("RESTful_TicTacToe");
	}

	@Override
	public void run(TicTacToeServiceConfiguration config, Environment environment) {
//    	String[][] defaultBoard = config.getDefaultBoard();
    	String defaultState = config.getDefaultState();
    	
//    	System.out.println("defaultState: " + defaultState + ", Printing defaultBoard: ");
//    	for (int row=0; row<defaultBoard.length; row++) {
//    		for (int column=0; column<defaultBoard[row].length; column++) {
//    			System.out.print(defaultBoard[row][column]);
//    		}
//    		System.out.println();
//    	}
    	
//    	Board dBoard = new Board(defaultBoard);
    	
        environment.addResource(new TicTacToeResource(defaultState));
	}
}