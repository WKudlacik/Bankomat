//Stan, który zostanie nadany w przypadku gdy aplikacja czeka na PIN

package stany;

import bankomat.Bankomat;

public class CzekaNaPin implements StanBankomatu {

	private static final int MAX_PROB_DLA_PIN = 3;
	int licznikNieudanych;

	@Override
	public String komunikat() {
		return "Podaj Pin: ";
	}

	@Override
	public void obsluzOperacje(Bankomat bankomat, String input) {
		if (input.equals("1234")) {
			System.out.println("OK, PIN poprawny");
			bankomat.setStanBankomatu(new WyborOperacji());
		} else {
			System.out.println("ZLY PIN");
			licznikNieudanych++;
			if (licznikNieudanych == MAX_PROB_DLA_PIN) {
				System.out.println(MAX_PROB_DLA_PIN + " razy podales zly pin");
				System.out.println("Zatrzymam karte");
				bankomat.setStanBankomatu(new BrakKarty());
			}
		}
	}

}
