package Task_1;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter
{
	
	private Map<String, Double>exchangeRates;
	public CurrencyConverter() 
	{
		exchangeRates = new HashMap<>();
	
	//Update real value from API
	exchangeRates.put("USD", 1.0);
	exchangeRates.put("EUR", 0.85);
	exchangeRates.put("GBP", 0.73);
	exchangeRates.put("JPY", 110.0);
	}
	public double convert(double amount,String fromCurrency, String toCurrency)
	{
		if(exchangeRates.containsKey(fromCurrency) && exchangeRates.containsKey(toCurrency))
		{
			double fromRate = exchangeRates.get(fromCurrency);
			double toRate = exchangeRates.get(toCurrency);
		    return amount * (toRate / fromRate);
		} else {
			throw new IllegalArgumentException("Currency not supported.");
		}
	}
	public String[] getSupportedCurrencies()
	{
		return exchangeRates.keySet().toArray(new String[0]);
		

	}

}
