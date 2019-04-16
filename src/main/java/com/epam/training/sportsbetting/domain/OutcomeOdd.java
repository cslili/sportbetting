package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOdd {
	
	private BigDecimal value;
	
	private LocalDateTime validFrom;
	
	private LocalDateTime validUntil;
	
	
	private Outcome outcome;

	
	

	public OutcomeOdd(BigDecimal value, LocalDateTime validFrom, LocalDateTime validUntil, Outcome outcome) {
		this(value, validFrom, outcome);
		this.validUntil = validUntil;
	}
	
	public OutcomeOdd(BigDecimal value, LocalDateTime validFrom, Outcome outcome) {
		this.value = value;
		this.validFrom = validFrom;
		this.validUntil = outcome.getBet().getEvent().getEndDate();
		this.outcome = outcome;
	}


	public BigDecimal getValue() {
		return value;
	}


	public LocalDateTime getValidFrom() {
		return validFrom;
	}


	public LocalDateTime getValidUntil() {
		return validUntil;
	}


	public Outcome getOutcome() {
		return outcome;
	}

	public SportEvent getSportEvent() {
		return outcome.getSportEvent();
	}

	
	

}
