import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);
        clavier.close();

        // Validation de la matrice
        if (!checkFormat(matrice)) {
            return;
        }

        // Trouver la liste des lignes avec le plus grand nombre de 1 consecutif
        // Ces numéros de lignes sont stockés dans un tableau dynamique
        ArrayList<Integer> maxConsecutifList = findConsecutiveList(matrice);

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1 !");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs :");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    static boolean checkFormat(String matrice) {
        if(matrice.isEmpty()){
            System.out.println("Matrice vide !");
            return false;
        }
        while (matrice.charAt(0) == ' ')
            matrice = matrice.substring(1);
        String[] lines = matrice.split(" {1,}");
        for (String line : lines) {
            for (int i = 0; i < line.length(); ++i) {
                int test = (int)line.charAt(i);
                if (line.charAt(i) != '0' && line.charAt(i) != '1') {
                    System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
                    return false;
                }
            }
        }
        if(!checkLineLength(matrice)) {
            System.out.println("Matrice invalide, lignes de longueurs differentes !");
            return false;
        }
        return true;
    }
    static boolean checkLineLength(String matrice) {
        while (matrice.charAt(0) == ' ')
            matrice = matrice.substring(1);
        String[] lines = matrice.split(" {1,}");
        for (String line : lines) {
            if (lines[0].length() != line.length())
                return false;
        }
        return true;
    }
    static ArrayList<Integer> findConsecutiveList(String matrice) {
        ArrayList<Integer> mostLine = new ArrayList<>();
        while (matrice.charAt(0) == ' ')
            matrice = matrice.substring(1);
        String[] lines = matrice.split(" {1,}");
        int[] arrayOne = new int[lines.length];
        int count = 0;
        int max = 0;
        for (String line : lines) {
            int nb = 0;
            String[] linesOne = line.split("0{1,}");
            for(String lineOne : linesOne) {
                if (lineOne.length() > nb)
                    nb = lineOne.length();
            }
            if (nb > max)
                max = nb;
            arrayOne[count] = nb;
            ++count;
        }
        if (max != 0) {
            for (int i = 0; i < arrayOne.length; ++i) {
                if (arrayOne[i] == max)
                    mostLine.add(i);
            }
        }
        return mostLine;
    }
    /*******************************************
     * Ne rien modifier apres cette ligne
     *******************************************/
}
