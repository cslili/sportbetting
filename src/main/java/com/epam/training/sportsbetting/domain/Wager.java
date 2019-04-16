package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {
	
	private BigDecimal amount;
	
	private LocalDateTime timestampCreated;
	
	private boolean processed;
	
	private boolean win;
	
	
	private OutcomeOdd odd;
	
	private Player player;
	
	private Currency currency;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Wager '")
			.append(odd.getOutcome().getBet().getDescription())
			.append("=").append(odd.getOutcome().getDescription())
			.append("' of ").append(odd.getOutcome().getBet().getEvent().getTitle())
			.append(" [odd: ").append(odd.getValue())
			.append(", amount: ").append(amount.toString())
			.append("] saved!");
			
		return sb.toString();
	}

	public Wager( LocalDateTime timestampCreated, OutcomeOdd odd, BigDecimal amount, Player player, Currency currency) {
		this(timestampCreated, odd, player, currency);
		this.amount = amount;
	}
	
	

	public Wager(LocalDateTime timestampCreated, OutcomeOdd odd, Player player, Currency currency) {
		super();
		this.timestampCreated = timestampCreated;
		this.odd = odd;
		this.player = player;
		this.currency = currency;
	}

	public OutcomeOdd getOdd() {
		return odd;
	}
	
	public BigDecimal getActualOdd() {
		return odd.getValue();
	}
	
	public Bet getBet() {
		return odd.getOutcome().getBet();
	}
	
	public Outcome getOutcome() {
		return odd.getOutcome();
	}
	
	public SportEvent getSportEvent() {
		return odd.getSportEvent();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean isWin() {
		return win;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
	
	
	
	
	
	
	
	
	

	

	

}
