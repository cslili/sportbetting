package com.epam.training.sportsbetting.service;

import java.util.List;

import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;

public interface SportsBettingService {
	
	void savePlayer(Player player);
	
	Player findPlayer();
	
	List<SportEvent> findAllSportEvents();
	
	void saveWager(Wager wager);
	
	List<Wager> findAllWagers();
	
	void calculateResults();	

}
