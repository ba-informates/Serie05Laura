class Benford {

	/* METHODES UTILTAIRES FOURNIES*/

	// affichage  d'un tableau d'entiers
	public static void print(int[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	// affichage  d'un tableau de doubles
	public static void print(double[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] frequencies = new int[9];
		double[] numbers = new double[25];

		//  TEST 1.1
		System.out.println("Test 1.1 : ");
		fillWithSquare(numbers);
		print(numbers);
		System.out.println();
		// FIN TEST 1.1 

		//TEST 1.2
		System.out.println("Test 1.2 : ");
		System.out.println(extractMaxDigit(0));
		System.out.println(extractMaxDigit(632));
		System.out.println(extractMaxDigit(-221));
		System.out.println(extractMaxDigit(-554.15));
		System.out.println(extractMaxDigit(0.00421));
		System.out.println();
		// FIN TEST 1.2

		//  TEST 1.3
		System.out.println("Test 1.3 : ");
		analyze(numbers, frequencies);
		print(frequencies);
		System.out.println();
		// FIN TEST 1.3

		// TEST 1.4
		System.out.println("Test 1.4 : ");
		testBenford(frequencies, numbers.length);
		// FIN TEST 1.4
	}
	static void fillWithSquare(double[] numbers) {
		for (int i = 0; i < numbers.length; ++i) {
			numbers[i] = Math.pow(i+1, 2) / 100;
		}
	}
	static int extractMaxDigit(double number) {
		if (number < 0)
			number *= -1;
		while (number % 1 != 0) {
			number *= 10;
		}
		while (number >= 10) {
			number /= 10;
		}
		return ((int)(number));
	}
	static void analyze(double[] numbers, int[] occurences) {
		for (int i = 0; i < occurences.length; ++i) {
			int nb = 0;
			for (int j = 0; j < numbers.length; ++j) {
				if (i+1 == extractMaxDigit(numbers[j]))
					nb++;
			}
			occurences[i]  = nb;
		}
	}
	static void testBenford (int[] occurences, int nbChiffres) {
		System.out.println("Pourcentage effectif / Predictions de la loi de Benford :");
		for (int i = 0; i < occurences.length; ++i) {
			double percent = occurences[i] * 100 / (double)nbChiffres;
			double benford = 100 * Math.log10(1 + (double)1/(i+1));
			System.out.println(i +". : " + percent +"%, Benford : " + benford + "%");
		}
	}
}

