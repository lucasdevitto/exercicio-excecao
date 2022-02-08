package model.entities;

import model.exceptions.AccountException;

public class Account {

	public Integer number;
	public String holder;
	public Double balance;
	public Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}

	public void withdraw(Double amount) throws AccountException {
		if (amount > withdrawLimit) {
			throw new AccountException("Erro de saque: A quantia excede o limite de saque");
		} else if (amount > balance) {
			throw new AccountException("Erro de saque: Saldo insuficiente");
		} else {
			this.balance -= amount;
		}
	}

	@Override
	public String toString() {
		return "New balance: " + balance;
	}
}
