//Stan, który zostanie nadany w przypadku, gdy aplikacja prosi o wybor akcji

package stany;

import bankomat.Bankomat;

public class WyborOperacji implements StanBankomatu {

	@Override
	public String komunikat() {
		return "Wybierz opcje. Mozliwe operacje: \"wyplac\", \"stan konta\" lub \"doladuj bankomat\"";
	}

	@Override
	public void obsluzOperacje(Bankomat bankomat, String input) {
		if (Operacje.WYPLAC == Operacje.getOperacja(input)) {
			bankomat.setStanBankomatu(new WyborKwoty());
		} else if (Operacje.STAN_KONTA == Operacje.getOperacja(input)) {
			System.out.println("Stan: " + bankomat.getStanKonta());
		} else if (Operacje.DOLADUJ_BANKOMAT == Operacje.getOperacja(input)) {
			bankomat.doladujBankomat(5000);
		}
	}

}
