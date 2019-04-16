package com.epam.training.sportsbetting.ui;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.Currency;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;

public class IOProvider implements IO {

	public Player readPlayerData() {
		
		System.out.println("What is your name?");
		String name = stringReader();
		
		System.out.println("How much money do you have?");
		BigDecimal balance = new BigDecimal(stringReader());
		
		System.out.println("What is your currency? (HUF, EUR or USD)");
		Currency currency = Currency.valueOf(stringReader());
		
		return new Player(name, balance, currency);
	}

	public void printWelcomeMessage(Player player) {
		System.out.printf("Welcome %s!%n", player.getName());

	}

	public void printBallance(Player player) {
		System.out.printf("Your balance is %,.0f %s%n", player.getBalance().floatValue(), player.getCurrency().toString());

	}

	public void printOutcomeOdds(List<SportEvent> sportEvents) {
		System.out.println("What are you want to bet on? (choose a number or press q for quit)");
		
		StringBuilder sb = new StringBuilder();
		
		int index = 1;
		for(SportEvent sportEvent : sportEvents) {
			
			for(Bet bet : sportEvent.getBets()) {				
				for(Outcome outcome : bet.getOutcomes()) {
						sb.append(index).append(": Sport event: ")
						.append(sportEvent.getTitle())
						.append(" (start: ").append(dateFormatter(sportEvent.getStartDate()))
						.append("), Bet: ").append(bet.getDescription())
						.append(", Outcome: ")
						.append(outcome.getDescription())
						.append(", Actual odd: ")
						.append(outcome.getActualOutcomeOdd().getValue())
						.append(", Valid between ")
						.append(dateFormatter(outcome.getActualOutcomeOdd().getValidFrom()))
						.append(" and ")
						.append(dateFormatter(outcome.getActualOutcomeOdd().getValidUntil()))
						.append(".")
						.append("\n");
						++index;
					
				}
			}
			
		}
		System.out.print(sb.toString());
	}

	/**
	 * returns null if the user do not want to do a new wager
	 */
	public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) {
		
		String input = stringReader();
		
		if(input.equals("q")) {
			return null;
		}
		
		int choosenItem = Integer.parseInt(input);
		int index = 1;

		for(SportEvent sportEvent : sportEvents) {
			
			for(Bet bet : sportEvent.getBets()) {				
				for(Outcome outcome : bet.getOutcomes()) {		
						if(index >= choosenItem) {
							return outcome.getActualOutcomeOdd();
						}
						++index;
				}
			}
		}
		return null;
		
	}

	public BigDecimal readWagerAmount() {
		System.out.println("What amount do you wish to bet on it?");
		return new BigDecimal(stringReader());
	}

	public void printWagerSaved(Wager wager) {
		System.out.println(wager.toString());

	}

	public void printNotEnoughBalance(Player player) {
		System.out.printf("You don't have enough money, your balance is %s %s%n", player.getBalance().toString(), player.getCurrency().toString());

	}

	public void printResult(Player player, List<Wager> wagers) {
		StringBuilder sb = new StringBuilder();
		sb.append("Results:\n");
		
		for(Wager wager : wagers) {
			sb.append("Wager '")
				.append(wager.getBet().getDescription()).append("=")
				.append(wager.getOutcome().getDescription()).append("' of ")
				.append(wager.getSportEvent().getTitle())
				.append(" [odd: ").append(wager.getActualOdd())
				.append(", amount: ").append(wager.getAmount().toString())
				.append("], win: ").append(wager.isWin()).append("\n");
		}
		
		System.out.println(sb.toString());
		
		System.out.printf("Your new balance is %,.0f %s%n", player.getBalance().floatValue(), player.getCurrency());

	}
	
	private String stringReader() {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		return line;
	}
	
	private String dateFormatter(LocalDateTime localDateTime) {
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
	}
	
}
