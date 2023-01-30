import java.util.Scanner; // Import l'outil scanner

public class Test { // Création d'une class Test
	public static void main (String [] arguments) { // Création d'une méthode statique main, qui renvoit une chaine de caractère en arguments	

		int nombreVariable; // Initialise nombreVariable

		int noeud; // Initialise noeud

		final int NOMBRE_MAXIMUM = 10; // Nombre maximum pour l'expression booléenne

		Scanner scanner = new Scanner (System.in); // Création d'un nouveau scanner, qui scanne la valeur

		System.out.println ("\n" + "Entrez le nombre de variable entre 0 et " + NOMBRE_MAXIMUM + " : "); // Affiche le nombre de variable maximum de l'expression booléenne

        nombreVariable = scanner.nextInt (); // Scanne la nouvelle valeur du nombreVariable

		System.out.println ("\n" + "Entrez le nombre de noeud entre 0 et " + NOMBRE_MAXIMUM + " : "); // Affiche le nombre de noeud maximum de l'expression booléenne

        noeud = scanner.nextInt (); // Scanne la nouvelle valeur du noeud

        while (nombreVariable <= 0 && noeud <= 0 || nombreVariable > NOMBRE_MAXIMUM && noeud > NOMBRE_MAXIMUM) { // Tant que le nombre de variable et de noeud est inférieur à 0 ou est supérieur au nombre maximum

            System.out.println ("\n" + "Nombre incorrect. Entrez un nombre de variable entre 0 et " + NOMBRE_MAXIMUM + " : "); // Affiche nombre incorrect et on redonne un nombre de variable maximum pour l'expression booléenne 

            nombreVariable = scanner.nextInt (); // Scanne la nouvelle valeur du nombreVariable

			System.out.println ("\n" + "Nombre incorrect. Entrez un nombre de noeud entre 0 et " + NOMBRE_MAXIMUM  + " : "); // Affiche nombre incorrect et on redonne un nombre de noeud maximum pour l'expression booléenne 

			noeud = scanner.nextInt (); // Scanne la nouvelle valeur du noeud
        }

		boolean [] vecteurBooleen = new boolean [nombreVariable]; // Création d'un nouveau boolean, qui est le vecteurBooleen du nombreVariable 

		for (int i = 0; i < vecteurBooleen.length; i++) { // Compte la taille du vecteurBooleen
			
			int valeurIntermediaire; // Initialise la valeur intermédiaire
			
			do { // Fait la valeur booleenne pour le vecteur booleen
				
				System.out.println ("\n" + "Entrez une valeur booleenne pour le vecteur booleen [" + i + "], 0 pour faux, 1 pour vrai : "); // Affiche entrer une valeur booleenne pour le vecteur booleen, 0 pour faux, 1 pour vrai
				
				valeurIntermediaire = scanner.nextInt (); // Scanne la nouvelle valeur intermediaire
			}
			
			while (valeurIntermediaire != 0 && valeurIntermediaire != 1); // Tant que la valeurIntermediaire n'est pas 0 ou 1 
			
			if (valeurIntermediaire == 0) { // Si la valeurIntermediaire est nul
				
				vecteurBooleen [i] = false; // VecteurBooleen est faux
			
			} else { // Sinon on retourne le vecteurBooleen
				
				vecteurBooleen [i] = true; // VecteurBooleen est vrai
			}
		}

		scanner.close (); // Ferme le scanner
		
		System.out.println ("\n" + "Expression booleenne du TD         : e = [((! a + (! d)) * c)) * ! c)]"); // Affiche l'expression booléenne du TD : e = [((! a + (! d)) * c)) * ! c)]
		System.out.println ("\n" + "Nombre de variable booleenne       : 3 avec a = true puis b et c = false"); // Affiche les variables booléennes : a = vrai puis b et c = faux
		System.out.println ("\n" + "Nombre de noeud                    : 4"); // Affiche le nombre de noeud : 4
		System.out.println ("\n" + "Resultat de l'expression booleenne : e = false"); // Affiche le résultat de l'expression booleenne : e = false
		
		System.out.println ("\n" + "--------------------------------------------------------------------------------------------------"); // Affiche une séparation
	
		System.out.println ("\n" + "Notre expression booleenne         : i = [((! a * (! d)) + (b * c))] + [((e + (! f)) * (! c) + f)]"); // Affiche notre expression booléenne : [((! a * (! d)) + (b * c))] + [((e + (! f)) * (! c) + f)]
		System.out.println ("\n" + "Nombre de variable booleenne       : 6 avec a, d et f = true puis b, c et e = false"); // Affiche les variables booléennes : a, d et f = vrai puis b, c et e = faux
		System.out.println ("\n" + "Nombre de noeud                    : 10"); // Affiche le nombre de noeud : 10
		System.out.println ("\n" + "Resultat de l'expression booleenne : i = true"); // Affiche le résultat de l'expression booleenne : i = true

		System.out.println ("\n" + "--------------------------------------------------------------------------------------------------"); // Affiche une séparation

		Noeud noeud1 = new Noeud (vecteurBooleen [--nombreVariable]); // Création d'un nouveau noeud1 avec des vecteurBooleen
				
		ExpressionBooleenne expressionBooleenne = new ExpressionBooleenne (noeud1); // Création d'une nouvelle expressionBooleenne du noeud1	

		System.out.println ("\n" + "Test une expression booleenne quelconque (TD et la notre ou autres)"); // Affiche test une expression booleenne quelconque (TD et la notre ou autres)

		System.out.println ("\n" + "Nombre de variable booleenne       : " + vecteurBooleen.length); // Affichage le nombre de variables booléennes

		System.out.println ("\n" + "Nombre de noeud                    : " + (noeud)); // Affiche le nombre de noeud

		expressionBooleenne.ecrire(); // Ecrit l'expression booléenne

		System.out.println ("Resultat de l'expression booleenne : " + expressionBooleenne.evaluer (vecteurBooleen)); // Affiche le résultat de l'expression booléenne
	}
}