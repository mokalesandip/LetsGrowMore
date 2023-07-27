package Task_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CurrencyConverter converter = new CurrencyConverter();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Currency Converter!");
		String[] supportedCurrencies = converter.getSupportedCurrencies();
		System.out.println("Supported Currencies: ");
		for (String currency : supportedCurrencies)
		{
			System.out.println(currency);
		}
		System.out.print("Enter the amount: ");
		double amount=sc.nextDouble();
		sc.nextLine();
		
		System.out.print("Enter the currency you eant to convert from (e.g.,USD, EUR): ");
		String fromCurrency = sc.nextLine().toUpperCase();
		
		System.out.print("Enter the currency you want to convert to (e.g.,USD, EUR): ");
		String toCurrency = sc.nextLine().toUpperCase();
		
		try {
			double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
			System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount +" " +toCurrency);
		}catch (IllegalArgumentException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();


	}

}
