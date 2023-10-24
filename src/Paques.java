import java.util.Scanner;

public class Paques {
    private final static Scanner CLAVIER = new Scanner(System.in);
    public static void main(String[] args) {
        int annee = demanderAnnee();
        int date = datePaques(annee);
        afficheDate(annee,date);
    }
    static int demanderAnnee() {
        int annee;
        do {
            System.out.println("Entrez une annee (1583-4000) : ");
            annee = CLAVIER.nextInt();
        } while (annee < 1583 || annee > 4000);
        return annee;
    }
    static void afficheDate (int annee, int nbJours) {
        System.out.print("Date de Paques en " + annee +" : ");
        if(nbJours <= 31)
            System.out.println(nbJours + " mars");
        else
            System.out.print((nbJours - 31) + " avril");
    }
    static int datePaques(int annee) {
        int siecle = annee / 100;
        int p = (13 + 8 * siecle)/25;
        int q = siecle/4;
        int m = (15 - p + siecle - q) % 30;
        int n = (4 + siecle - q) % 7;
        int d = (m + 19 * (annee % 19)) % 30;
        int e = (2 * (annee % 4) + 4 * (annee % 7) + 6 * d + n) % 7;
        int jour = e + d + 22;
        if ((e == 6 && d == 29) || (e == 6 && d == 28 && (11 * (m+1))%30 < 19))
            jour -= 7;
        return jour;
    }
}
