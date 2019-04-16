package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

public class FootballSportEvent extends SportEvent {

	public FootballSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets) {
		super(title, startDate, endDate, bets);
		// TODO Auto-generated constructor stub
	}

	public FootballSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
		super(title, startDate, endDate);
		// TODO Auto-generated constructor stub
	}

	
	
	

}
