package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportEvent {

	protected String title;
	
	protected LocalDateTime startDate;
	
	protected LocalDateTime endDate;
	
	protected List<Bet> bets;
	
	protected Result result;
	
	

	public SportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bets = new ArrayList<Bet>();
		this.result = new Result();
	}

	public SportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets) {
		this(title, startDate, endDate);
		this.bets = bets;
	}

	public String getTitle() {
		return title;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public List<Bet> getBets() {
		return bets;
	}
	
	

	public Result getResult() {
		return result;
	}
	
	public void addBet(Bet bet) {
		bets.add(bet);
	}

	public void addResult(Outcome outcome) {
		this.result.addResult(outcome);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		SportEvent other = (SportEvent) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	
	}
	
	
	
	
	
	

