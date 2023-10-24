import java.awt.desktop.AboutEvent;
import java.util.Scanner;

public class Rectangle {
    static private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double largeur = lireDonnee("largeur");
        double hauteur = lireDonnee("hauteur");

        boolean donneesOk = testerDonnees(largeur, hauteur);

        if (donneesOk) {
            calculer(largeur, hauteur);
        } else {
            afficherErreur();
        }
    }
    static double lireDonnee(String type) {
        System.out.println("Entrez la "+ type +":");
        return (scanner.nextDouble());
    }
    static boolean testerDonnees(double largeur, double hauteur) {
        boolean test = true;
        if (largeur < 0 || hauteur < 0)
            test = false;
        return test;
    }
    static void calculer(double largeur, double hauteur) {
        System.out.println("Surface ('s/S') ou perimètre ('p/P')?:");
        char type = scanner.next().charAt(0);
        switch (type) {
            case 's':
            case 'S':
                System.out.println("La surface est de " + largeur*hauteur + "m²");
                break;
            case 'p':
            case 'P':
                System.out.println("Le périmètre est de " + (largeur*2 +hauteur*2) + "m");
                break;
        }
    }
    static void afficherErreur() {
        System.out.println("Erreur: vous avez introduit une largeur ou une hauteur négative!");
    }
}
