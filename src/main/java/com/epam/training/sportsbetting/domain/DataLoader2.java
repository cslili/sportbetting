package com.epam.training.sportsbetting.domain;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DataLoader2 {

	
	public static List<SportEvent> loadData() {
		
		List<SportEvent> sportEvents = new ArrayList<>();
		
		SportEvent firstEvent = new FootballSportEvent("Southampton v Bournemoth",
				LocalDateTime.of(2019, Month.MAY, 27, 19, 0),
				LocalDateTime.of(2019, Month.MAY, 27, 21, 0)
				);
		Bet firstBet = new Bet("winner", firstEvent, BetType.WINNER);
		firstBet.addOutcome("Southampton");
		firstBet.getOutcomes().get(0).changeOutcomeOdd(new BigDecimal("4"), LocalDateTime.of(2019, Month.MARCH, 27, 19, 00), LocalDateTime.of(2019, Month.APRIL, 2, 18, 59));
		firstBet.getOutcomes().get(0).changeOutcomeOdd(new BigDecimal("5"), LocalDateTime.of(2019, Month.APRIL, 2, 19, 00), LocalDateTime.of(2019, Month.APRIL, 2, 18, 59));
		
		firstBet.addOutcome("Bournemoth");
		firstBet.getOutcomes().get(1).changeOutcomeOdd(new BigDecimal("4"), LocalDateTime.of(2019, Month.MARCH, 27, 19, 00), LocalDateTime.of(2019, Month.APRIL, 2, 18, 59));
		firstBet.getOutcomes().get(1).changeOutcomeOdd(new BigDecimal("5"), LocalDateTime.of(2019, Month.APRIL, 2, 19, 00));
		
		firstBet.addOutcome("Draw");
		firstBet.getOutcomes().get(2).changeOutcomeOdd(new BigDecimal("4"), LocalDateTime.of(2019, Month.MARCH, 27, 19, 00), LocalDateTime.of(2019, Month.APRIL, 2, 18, 59));
		firstBet.getOutcomes().get(2).changeOutcomeOdd(new BigDecimal("5"), LocalDateTime.of(2019, Month.APRIL, 2, 19, 00));
		
		
		firstEvent.addBet(firstBet);
		
		Bet secontBet = new Bet("number of scored goals", firstEvent, BetType.GOALS);
		secontBet.addOutcome("0");
		secontBet.getOutcomes().get(0).changeOutcomeOdd(new BigDecimal("1.75"), LocalDateTime.of(2019, Month.APRIL, 2, 19, 00), LocalDateTime.of(2019, Month.APRIL, 2, 18, 59));
		
		secontBet.addOutcome("1");
		secontBet.getOutcomes().get(1).changeOutcomeOdd(new BigDecimal("1.25"), LocalDateTime.of(2019, Month.APRIL, 2, 19, 00));
		
		secontBet.addOutcome(">=2");
		secontBet.getOutcomes().get(2).changeOutcomeOdd(new BigDecimal("1.05"), LocalDateTime.of(2019, Month.APRIL, 2, 19, 00));
		
		
		firstEvent.addBet(secontBet);
		
		sportEvents.add(firstEvent);
		
		
		SportEvent secondEvent = new TennisSportEvent("Bernard Tomic v Denis Kudla",
				LocalDateTime.of(2019, Month.APRIL, 9, 17, 00),
				LocalDateTime.of(2019, Month.APRIL, 9, 19, 00)
				);
		Bet thirdBet = new Bet("winner", secondEvent, BetType.WINNER);
		thirdBet.addOutcome("Bernard Tomic");
		thirdBet.getOutcomes().get(0).changeOutcomeOdd(new BigDecimal("2.20"), LocalDateTime.of(2019, Month.MARCH, 27, 19, 00), LocalDateTime.of(2019, Month.APRIL, 9, 16, 59));
		
		thirdBet.addOutcome("Denis Kudla");
		thirdBet.getOutcomes().get(1).changeOutcomeOdd(new BigDecimal("1.61"), LocalDateTime.of(2019, Month.MARCH, 27, 19, 00), LocalDateTime.of(2019, Month.APRIL, 9, 16, 59));
		
		
		secondEvent.addBet(thirdBet);
		
		sportEvents.add(secondEvent);
		
		return sportEvents;
	}
	


}
