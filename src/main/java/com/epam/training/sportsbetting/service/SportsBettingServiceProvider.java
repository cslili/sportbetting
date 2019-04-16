package com.epam.training.sportsbetting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.DataLoader;
import com.epam.training.sportsbetting.domain.DataLoader2;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;

public class SportsBettingServiceProvider implements SportsBettingService {
	
	private Player player;
	
	private List<Wager> wagers;
	

	public SportsBettingServiceProvider() {
		wagers = new ArrayList<Wager>();
	}

	public void savePlayer(Player player) {
		this.player = player;

	}

	public Player findPlayer() {
		return player;
	}

	public List<SportEvent> findAllSportEvents() {
		List<SportEvent> sportEvents = DataLoader.loadData();
		
		return sportEvents;
	}

	public void saveWager(Wager wager) {
		wagers.add(wager);
		findPlayer().subtractAmountFromBalance(wager.getAmount());
		wager.setProcessed(true);

	}

	public List<Wager> findAllWagers() {
		return wagers;
	}

	public void calculateResults() {
		Random random = new Random();
		for(SportEvent sportEvent : findAllSportEvents()) {
			
			for(Bet bet : sportEvent.getBets()) {
				if(bet.getOutcomes().size() >  1 ) {
					int winner = random.nextInt(bet.getOutcomes().size());
					int index = 0;
					for(Outcome outcome : bet.getOutcomes()) {
						if(index == winner) {
							sportEvent.addResult(outcome);
							setResultsInWagers(outcome);
						}
						index++;
					}
				} else  if(bet.getOutcomes().size() == 1){
					if(random.nextBoolean()) {
						sportEvent.addResult(bet.getOutcomes().get(0));
						setResultsInWagers(bet.getOutcomes().get(0));
					}
				}
				
			}
		}

		addWinnerPrizeToPlayer();

	}

	private void addWinnerPrizeToPlayer() {
		for(Wager wager : wagers) {
			if(wager.isWin() && wager.isProcessed()) {
				findPlayer().addAmountToBalance(wager.getAmount().multiply(wager.getActualOdd()));
			}
		}
	}


	private void setResultsInWagers(Outcome outcome) {
		for(Wager wager : wagers) {
			if(wager.getOutcome().equals(outcome)) {
				wager.setWin(true);
			}
		}
	}

}

	