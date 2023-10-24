import java.util.Scanner;
import java.util.ArrayList;

class Cesure {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		String[] phrase = lirePhrase();
		for (int i = 0; i < phrase.length; i++) {
			cesure(phrase[i]);
		}
	}

	static String[] lirePhrase() {
		int nb;
		do {
			System.out.print("Donnez le nombre de mots dans votre phrase: ");
			nb = scanner.nextInt();
			if (nb <= 0)
				System.out.println("Entrez une valeur plus grande que 0");
		} while (nb <= 0);
		String[] mots = new String[nb];
		for (int i = 0; i < nb; ++i) {
			System.out.print("Donnez le mot " + (i+1) +" : ");
			mots[i] = scanner.next();
		}
		return mots;
		// retourne un tableau de chaines de caractères
		// introduits par l'utilisateur
	}

	static boolean voyelle(char c) {
		final char[] voyelles = {'a','e','i','o','u','y'};
		for (char voyelle : voyelles) {
			if (c == voyelle)
				return true;
		}
		return false;
		// teste si un caractère est une voyelle
	}

	static boolean queVoyelles(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (!voyelle(s.charAt(i)))
				return false;
		}
		return true;
		// teste si une chaîne ne contient que des voyelles
		// utilise la méthode voyelle
	}

	static void cesure(String mot) {
		String part;
		int indexLastVoyelle = 0;
		if (mot.length() < 4)
			System.out.println(mot);
		else if (queVoyelles(mot)) {
			System.out.println(mot);
		} else {
			for (int i = 1; i < mot.length()-2; ++i) {
				if (voyelle(mot.charAt(i)) && !voyelle(mot.charAt(i+1))) {
					System.out.println(mot.substring(indexLastVoyelle, i+1)+'-');
					indexLastVoyelle = i+1;
				}
			}
			System.out.println(mot.substring(indexLastVoyelle));
		}
		// détermine la césure d'un mot donné et effectue les affichages
		// correspondants (voir exemple de déroulement)
	}
}
