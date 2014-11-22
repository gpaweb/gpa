package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class CommonFunctions {

	private CommonFunctions(){}
	
	public static String displayCurrency(BigDecimal value) {
		String currencyValue = new String();
		NumberFormat currencyFormat = NumberFormat
				.getCurrencyInstance(Locale.CANADA);
		currencyValue = currencyFormat.format(value);
		return currencyValue;
	}
}
