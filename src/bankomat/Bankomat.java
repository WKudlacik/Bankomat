//Klasa zawierająca obiekt Bankomat.

package bankomat;

import java.util.Scanner;
import stany.BrakKarty;
import stany.Operacje;
import stany.StanBankomatu;

public class Bankomat {

	private int stanKonta = 5000;
	private int dostepnePieniadze = 4000;
	private StanBankomatu stanBankomatu;

	public int getDostepnePieniadze() {
		return dostepnePieniadze;
	}

	public void setDostepnePieniadze(int dostepnePieniadze) {
		this.dostepnePieniadze = dostepnePieniadze;
	}

	public int getStanKonta() {
		return stanKonta;
	}

	public void setStanKonta(int stanKonta) {
		this.stanKonta = stanKonta;
	}

	public Bankomat() {
		stanBankomatu = new BrakKarty();
	}

	public StanBankomatu getStanBankomatu() {
		return stanBankomatu;
	}

	public void setStanBankomatu(StanBankomatu stanBankomatu) {
		this.stanBankomatu = stanBankomatu;
	}

	public void wypiszKomunikat() {
		System.out.println(stanBankomatu.komunikat());
	}

	public void obsluzOperacje(String operacja) {
		if (Operacje.ANULUJ == Operacje.getOperacja(operacja)) {
			setStanBankomatu(new BrakKarty());
		}
		stanBankomatu.obsluzOperacje(this, operacja);
	}

	public String pobierzOperacje() {
		Scanner scanner = new Scanner(System.in);
		String operacja = scanner.nextLine();
		return operacja;
	}
	
	public void doladujBankomat(int kwota) {
		int sumaPieniedzy = getDostepnePieniadze() + kwota;
		setDostepnePieniadze(sumaPieniedzy);
		System.out.println("Doładowano bankomat za: " + kwota);
	}

}
