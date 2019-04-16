package com.epam.training.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
	
	private List<Outcome> winnerOutcomes;

	public Result() {
		this.winnerOutcomes = new ArrayList<Outcome>();
	}
	
	void addResult(Outcome outcome) {
		this.winnerOutcomes.add(outcome);
	}

	/**
	 * 
	 * The method returns a new list
	 */
	public List<Outcome> getWinnerOutcomes() {
		return new ArrayList<Outcome>(winnerOutcomes);
	}
	
	
	
	

}
