package com.epam.training.sportsbetting;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.service.SportsBettingService;
import com.epam.training.sportsbetting.service.SportsBettingServiceProvider;
import com.epam.training.sportsbetting.ui.IO;
import com.epam.training.sportsbetting.ui.IOProvider;

public class App {
	
	private SportsBettingService sportsBettingService;
	
	private IO io;
	
	

	public static void main(String[] args) {
		
		App app = new App(new SportsBettingServiceProvider(), new IOProvider());
		
		app.play();
		

	}
	
	public App(SportsBettingService sportsBettingService, IO io) {
		this.sportsBettingService = sportsBettingService;
		this.io = io;
	}
	
	public void play() {
		
		createPlayer();
		
		io.printWelcomeMessage(sportsBettingService.findPlayer());
		io.printBallance(sportsBettingService.findPlayer());
		
		doBetting();
		
		calculateResults();
		
		printResults();
	}
	
	
	private void createPlayer() {
		sportsBettingService.savePlayer(io.readPlayerData());
		
	}
	
	private void doBetting() {
		boolean isEnded = false;
		while(!isEnded) {
			
			io.printOutcomeOdds(sportsBettingService.findAllSportEvents());

			Wager wager = new Wager(
				LocalDateTime.now(), 
				io.selectOutcomeOdd(sportsBettingService.findAllSportEvents()),
				sportsBettingService.findPlayer(), 
				sportsBettingService.findPlayer().getCurrency());
			if(Objects.equals(wager.getOdd(), null)) {
				isEnded = true;
			} else {
				wager.setAmount(wagerAmountValidater());
				sportsBettingService.saveWager(wager);
		
				io.printWagerSaved(wager);
				io.printBallance(sportsBettingService.findPlayer());
			}
		}
		
	}

	private BigDecimal wagerAmountValidater() {
		BigDecimal amount;
		boolean isValid = false;		
		do {
			amount = io.readWagerAmount();
			if(amount.compareTo(sportsBettingService.findPlayer().getBalance()) > 0 ) {
				io.printNotEnoughBalance(sportsBettingService.findPlayer());
			} else {
				isValid = true;
			}
		} while (!isValid);
		return amount;
	}
	
	private void calculateResults() {
		sportsBettingService.calculateResults();
		
	}
	
	private void printResults() {
		io.printResult(sportsBettingService.findPlayer(), sportsBettingService.findAllWagers());
	}
	
	
	

}
