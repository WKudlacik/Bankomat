//Główna klasa aplikacji. Wywoływane są tu dwie najważniejsze metody aplikacji.
 
package bankomat;

import bankomat.Bankomat;

public class Aplikacja {

	public static void main(String[] args) {

		Bankomat bankomat = new Bankomat();
		bankomat.wypiszKomunikat();
		String input;

		while ((input = bankomat.pobierzOperacje()) != null) {
			bankomat.obsluzOperacje(input);
			bankomat.wypiszKomunikat();
		}
	}

}