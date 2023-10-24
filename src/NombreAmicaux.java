public class NombreAmicaux {
    public static void main(String[] args) {
        int[] nombres = {1210, 45, 27, 220, 54, 284, 9890, 120, 1184};
        System.out.println("Les paires de nombres amicaux sont : ");
        afficherAmicaux(nombres);
    }
    static void afficherAmicaux(int[] nombres) {
        for (int i = 0; i < nombres.length; ++i) {
            for (int j = i+1; j < nombres.length; ++j)
                if(isAmicaux(nombres[i], nombres[j])) {
                    System.out.println(nombres[i] + " " + nombres[j]);
                }
        }
    }
    static boolean isAmicaux (int a, int b) {
        int sommeDivA = Diviseur(a);
        int sommeDivB = Diviseur(b);
        return sommeDivB == sommeDivA && sommeDivA == a + b;
    }
    static int Diviseur(int a) {
        int somme = 0;
        for (int i = 1; i <= a; ++i) {
            if (a % i == 0)
                somme += i;
        }
        return somme;
    }
}
