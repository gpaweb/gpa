package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public final class CommonFunctions {

	private CommonFunctions() {
	}

	// Surcharge de la fonction pour les type BigDecimal
	public static String displayCurrency(BigDecimal value) {
		String currencyValue = new String();
		NumberFormat currencyFormat = NumberFormat
				.getCurrencyInstance(Locale.CANADA);
		currencyValue = currencyFormat.format(value);
		return currencyValue;
	}

	// Surcharge de la fonction pour les type double
	public static String displayCurrency(double value) {
		String currencyValue = new String();
		NumberFormat currencyFormat = NumberFormat
				.getCurrencyInstance(Locale.CANADA);
		currencyValue = currencyFormat.format(value);
		return currencyValue;
	}

	public static LocalDate getLocalDateFromString(String date)
			throws Exception {
		System.out.println("Date :" + date);
		LocalDate dateFormated = LocalDate.parse(date);
		return dateFormated;
	}
}
