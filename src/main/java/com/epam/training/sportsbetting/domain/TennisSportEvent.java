package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

public class TennisSportEvent extends SportEvent {

	public TennisSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets) {
		super(title, startDate, endDate, bets);
		// TODO Auto-generated constructor stub
	}

	public TennisSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
		super(title, startDate, endDate);
		// TODO Auto-generated constructor stub
	}

	
	
}
