// Enum, który zawiera wszystkie dostęone w aplikacji operacje

package stany;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Operacje {

	WSADZENIE_KARTY("wsadzenie karty", "karta"), ANULUJ("anuluj"), WYPLAC("wyplac"), STAN_KONTA("stan konta"), DOLADUJ_BANKOMAT("doladuj bankomat"), COFNIJ("cofnij"), ZAKONCZ("zakoncz"), NIEROZPOZNANA("nierozpoznana");

	private Set<String> oczekiwaneInputy;

	static public Operacje getOperacja(String input) {
		for (Operacje value : values()) {
			if (value.oczekiwaneInputy.contains(input.toLowerCase().trim())) {
				return value;
			}
		}
		return NIEROZPOZNANA;
	}

	Operacje(String... input) {
		oczekiwaneInputy = new HashSet<>(Arrays.asList(input));
	}

}
