//Stan, który zostanie nadany w przypadku braku srodkow w bankomacie

package stany;

import bankomat.Bankomat;

public class BrakSrodkow implements StanBankomatu {

	@Override
	public String komunikat() {
		return "Brak srodkow w bankomacie";
	}

	@Override
	public void obsluzOperacje(Bankomat bankomat, String input) {

	}
}
