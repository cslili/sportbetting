package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Outcome {
	
	private String description;
	
	
	private Bet bet;
	
	// the first element of the list is the actual odd value
	private List<OutcomeOdd> outcomeOdds;

	public String getDescription() {
		return description;
	}

	public Bet getBet() {
		return bet;
	}

	public OutcomeOdd getActualOutcomeOdd() {
		return outcomeOdds.get(0);
	}
	
	
	public void changeOutcomeOdd(BigDecimal value, LocalDateTime validFrom, LocalDateTime validUntil) {
		outcomeOdds.add(0, new OutcomeOdd(value, validFrom, validUntil, this));
	}
	
	public void changeOutcomeOdd(BigDecimal value, LocalDateTime validFrom) {
		outcomeOdds.add(0, new OutcomeOdd(value, validFrom, this));
	}

	public Outcome(String description, Bet bet) {
		this.description = description;
		this.bet = bet;
		this.outcomeOdds = new ArrayList<OutcomeOdd>();
	}

	public SportEvent getSportEvent() {
		return bet.getEvent();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bet == null) ? 0 : bet.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Outcome other = (Outcome) obj;
		if (bet == null) {
			if (other.bet != null)
				return false;
		} else if (!bet.equals(other.bet))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	
	
	
	

	
	
	

}
