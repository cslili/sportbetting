package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player extends User {
	
	private String name;
	
	private Integer accountNumber;
	
	private BigDecimal balance;
	
	private LocalDate birth;
	
	
	private Currency currency;


	
	
	public Player(String name, BigDecimal balance, Currency currency) {
		this.name = name;
		this.balance = balance;
		this.currency = currency;
	}


	public String getName() {
		return name;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public Currency getCurrency() {
		return currency;
	}


	public void subtractAmountFromBalance(BigDecimal price) {
		this.balance = this.balance.subtract(price);
		
	}
	
	public void addAmountToBalance(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}
	
	


	

}
