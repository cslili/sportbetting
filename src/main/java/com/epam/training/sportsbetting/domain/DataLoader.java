package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

	public static List<SportEvent> loadData() {
		
		List<SportEvent> sportEvents = new ArrayList<>();
		
		SportEvent firstEvent = new FootballSportEvent("Arsenal vs Chelsea", 
				LocalDateTime.of(2020, Month.JANUARY, 1, 12, 00),
				LocalDateTime.of(2020, Month.JANUARY, 1, 14, 00));
		
		Bet firstBet = new Bet("player Oliver Giroud score", firstEvent, BetType.PLAYER_SCORE);
		firstBet.addOutcome("1");
		firstBet.getOutcomes().get(0).changeOutcomeOdd(new BigDecimal("2"), LocalDateTime.of(2000, Month.JANUARY, 1, 12, 00), LocalDateTime.of(2020, Month.JANUARY, 1, 12, 00));
		firstEvent.addBet(firstBet);
		
		Bet secondBet = new Bet("number of scored goals", firstEvent, BetType.GOALS);
		secondBet.addOutcome("3");
		secondBet.getOutcomes().get(0).changeOutcomeOdd(new BigDecimal("3"), LocalDateTime.of(2000, Month.JANUARY, 1, 12, 00), LocalDateTime.of(2020, Month.JANUARY, 1, 12, 00));
		firstEvent.addBet(secondBet);
		
		Bet thirdBet = new Bet("winner", firstEvent, BetType.WINNER);
		thirdBet.addOutcome("Arsenal");
		thirdBet.getOutcomes().get(0).changeOutcomeOdd(new BigDecimal("2"), LocalDateTime.of(2000, Month.JANUARY, 1, 12, 00), LocalDateTime.of(2020, Month.JANUARY, 1, 12, 00));
		thirdBet.addOutcome("Chelsea");
		thirdBet.getOutcomes().get(1).changeOutcomeOdd(new BigDecimal("3"), LocalDateTime.of(2000, Month.JANUARY, 1, 12, 00), LocalDateTime.of(2020, Month.JANUARY, 1, 12, 00));
		firstEvent.addBet(thirdBet);
		
		sportEvents.add(firstEvent);
		
		return sportEvents;
		
	}
}
