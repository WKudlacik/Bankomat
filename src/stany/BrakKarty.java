//Stan, który zostanie nadany w przypadku braku karty

package stany;

import bankomat.Bankomat;

public class BrakKarty implements StanBankomatu {

	@Override
	public String komunikat() {
		return "Witaj w banku Szmallenium. Wloz karte: ";
	}
	
	@Override
	public void obsluzOperacje(Bankomat bankomat, String input) {
		if(Operacje.WSADZENIE_KARTY == Operacje.getOperacja(input)) {
			System.out.println("Wsadziles karte");
			bankomat.setStanBankomatu(new CzekaNaPin());
		}
		else {
			System.out.println("Najpierw wsadz karte");
		}
	}
	
}
