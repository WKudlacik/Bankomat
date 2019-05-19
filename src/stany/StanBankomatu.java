// Interfejs zarządzający wzorcem stanów

package stany;

import bankomat.Bankomat;

public interface StanBankomatu {

	String komunikat();

	void obsluzOperacje(Bankomat bankomat, String input);

}
