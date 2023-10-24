import java.util.Scanner;
public class Mastermind {
    final static int n  = 4;
    final static int m = 6;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] laCombinaison = new int[n];
        int[] combinaison = new int[n];
        int[] reponse = new int[2];
        boolean trouver = false;
        tirerCombinaison(laCombinaison);
        int nombreCoups = 1;
        while (nombreCoups <= 10 && !trouver) {
            demanderCoup(combinaison);
            trouver = compare(laCombinaison, combinaison, reponse);
            afficheReponse(reponse);
            ++nombreCoups;
        }
        if (trouver)
            System.out.println("Bravo vous avez trouvé en " + nombreCoups + " coups");
        else
            afficheCombinaison(laCombinaison);
    }
    static void tirerCombinaison (int[] uneCombinaison) {
        for (int i = 0; i < uneCombinaison.length; ++i) {
            uneCombinaison[i] = hasard(m);
        }
    }
    static int hasard(int max) {
        return (1 + (int)(Math.random() * max));
    }
    static void demanderCoup(int[] uneCombinaison) {
        System.out.println("Entrez les " + uneCombinaison.length + " chiffres de votre propositiom : ");
        for (int i = 0; i < uneCombinaison.length; ++i) {
            uneCombinaison[i] = scanner.nextInt();
        }
    }
    static boolean compare(int[] laCombinaison, int[] uneCombinaison, int[] reponse) {
        int nbCorrect = 0;
        int nbMalPlace = 0;
        boolean[] numbers = new boolean[laCombinaison.length];
        for (int i = 0; i < laCombinaison.length; ++i) {
            if(laCombinaison[i] == uneCombinaison[i]) {
                ++nbCorrect;
                numbers[i] = true;
            }
        }
        if (nbCorrect == laCombinaison.length) {
            reponse[0] = nbCorrect;
            reponse[1] = 0;
            return true;
        }
        for (int i = 0; i < uneCombinaison.length; ++i) {
            if(uneCombinaison[i] != laCombinaison[i]) {
                for (int j = 0; j < laCombinaison.length; ++j) {
                    if (uneCombinaison[i] == laCombinaison[j] && !numbers[j]) {
                        numbers[j] = true;
                        ++nbMalPlace;
                        break;
                    }
                }
            }
        }
        reponse[0] = nbCorrect;
        reponse[1] = nbMalPlace;
        return false;
    }
    static void afficheCombinaison(int[] combinaison) {
        System.out.print("Désolé vous n'avez pas trouvé \n La bonne réponse était ");
        for(int i : combinaison)
            System.out.print(i + " ");
    }
    static void afficheReponse(int[] reponse){
        for(int j = 0; j < reponse[0]; j++)
            System.out.print("#");
        for(int j = 0; j < reponse[1]; j++)
            System.out.print("0");
        System.out.println();
    }
}
