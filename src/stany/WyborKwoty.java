//Stan, który zostanie nadany w przypadku, gdy aplikacja prosi o wybor kwoty

package stany;

import bankomat.Bankomat;

public class WyborKwoty implements StanBankomatu {

	private static final int LIMIT_WYPLAT = 1000;

	@Override
	public String komunikat() {
		return "Kwota wyplaty: ";
	}

	@Override
	public void obsluzOperacje(Bankomat bankomat, String input) {
		int dostepnePieniadze = bankomat.getDostepnePieniadze();
		
		if (Operacje.COFNIJ == Operacje.getOperacja(input)) {
			bankomat.setStanBankomatu(new WyborOperacji());
		} else if (Integer.valueOf(input) > LIMIT_WYPLAT) {
			System.out.println("Limit wyplat to " + LIMIT_WYPLAT);
		} else if (dostepnePieniadze < Integer.valueOf(input)) {
			bankomat.setStanBankomatu(new BrakSrodkow());
		} else {
			int stanKonta = bankomat.getStanKonta();

			if (stanKonta < Integer.valueOf(input)) {
				System.out.println("Brak srodkow na koncie");
			} else {
				int result = (stanKonta - Integer.valueOf(input));
				bankomat.setStanKonta(result);
				bankomat.setDostepnePieniadze(dostepnePieniadze - Integer.valueOf(input)); 
				System.out.println("Wyplacono: " + Integer.valueOf(input));
			}
		}
	}

}
