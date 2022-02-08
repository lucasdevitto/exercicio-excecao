package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
			System.out.println("Informe os dados da conta");
			
			System.out.print("Número: ");
			int number = sc.nextInt();
			System.out.print("Titular: ");
			String holder = sc.next();
			System.out.print("Saldo inicial: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Limite de saque: ");
			Double withdrawLimit = sc.nextDouble();
			
			System.out.println();
			Account acc = new Account(number, holder, initialBalance, withdrawLimit);
			System.out.print("Informe uma quantia para sacar: ");
			Double amount = sc.nextDouble();
			
			try {
				acc.withdraw(amount);
				System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
			}  catch (AccountException e) {
				System.out.println(e.getMessage());
			}
			
		sc.close();
	}
}
