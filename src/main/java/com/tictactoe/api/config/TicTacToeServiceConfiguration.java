package com.tictactoe.api.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class TicTacToeServiceConfiguration extends Configuration {

	private String defaultState;

	@JsonProperty
	public String getDefaultState() {
		return defaultState;
	}

	@JsonProperty
	public void setDefaultState(String defaultState) {
		this.defaultState = defaultState;
	}
}