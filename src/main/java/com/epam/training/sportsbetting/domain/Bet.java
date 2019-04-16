package com.epam.training.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

public class Bet {
	
	private String description;
	
	
	private SportEvent event;
	
	private List<Outcome> outcomes;
	
	private BetType type;
	
	

	public Bet(String description, SportEvent event, BetType type) {
		this.description = description;
		this.event = event;
		this.type = type;
		this.outcomes = new ArrayList<Outcome>();
	}

	public String getDescription() {
		return description;
	}

	public List<Outcome> getOutcomes() {
		return outcomes;
	}

	public BetType getType() {
		return type;
	}
	
	public void addOutcome(String desciption) {
		outcomes.add(new Outcome(desciption, this));
	}

	public SportEvent getEvent() {
		return event;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Bet other = (Bet) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (type != other.type)
			return false;
		return true;
	}


	
	
	

}
