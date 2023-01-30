public class ExpressionBooleenne extends Exception { // Création d'une class ExpressionBooleenne, qui est étendu à celle de l'Exception

	private Noeud racine; // Racine de l'expression booléenne
	private Noeud courant; // Noeud courant, parcourt l'expression booléenne

	public ExpressionBooleenne filsGauche; // FilsGauche de l'expression booléenne
	public ExpressionBooleenne filsDroit; // FilsDroit de l'expression booléenne

	public ExpressionBooleenne (Noeud racine) { // Création d'un constructeur de l'ExpressionBooleenne avec un paramètre racine, qui est la racine de l'expression booleenne
	
		this.racine = racine; // Racine de l'expression booléenne

		this.courant = null; // Noeud courant est vide

		try { // Lance l'exception de l'expression booleenne

			this.filsGauche = new ExpressionBooleenne (this.racine.getFilsGauche ()); // Création de la racine du fils gauche

			this.filsDroit = new ExpressionBooleenne (this.racine.getFilsDroit ()); // Création de la racine du fils droit
		}

		catch (NullPointerException nullPointerException) { // Gère l'exception de l'expression booléenne

			System.out.println ("\n" + "nullPointerException : " + nullPointerException.getMessage ()); // Affiche le message du pointeur nul exception de l'expression booléenne
		}

		finally { // Lève l'exception de l'expression booléenne

			System.out.println ("\n" + "Leve le nullPointerException de la racine : " + this.racine); // Affiche leve le pointeur nul exception de la racine
		}
	}
	
	public boolean estVide () { // Création d'un boolean (méthode) estVide, qui vérifie la racine du noeud

		if (this.racine == null) { // Si la racine du noeud est vide 

			return true; // Retourne la racine du noeude est vide

		} else { // Sinon on retourne que la racine du noeud n'est pas vide

			return false; // Retourne la racine du noeud n'est vide
		}
	}
	
	public ExpressionBooleenne singleton (boolean booleen) { // Création d'une ExpressionBooleenne (méthode statique) singleton, qui est un singleton booleen
		
		Noeud noeud = new Noeud (booleen); // Création d'un nouveau noeud, qui est booleen

		ExpressionBooleenne resultat = new ExpressionBooleenne (noeud); // Création d'un nouveau resultat, qui est le resultat du noeud
		
		return resultat; // Retourne le resultat
	}
	
	public ExpressionBooleenne disjonction (ExpressionBooleenne expressionBooleenne) { // Création d'une ExpressionBooleenne (méthode) disjonction, qui est une disjonction (ou) de l'expressionBooleenne
		
		ExpressionBooleenne resultat; // Resultat de l'expression booléenne
		
		boolean contenu = (this.racine.getContenu () || expressionBooleenne.racine.getContenu ()); // Contenu de la racine ou le contenu de la racine de l'expression booléenne

		Noeud racineBis = new Noeud (contenu); // Création d'une nouvelle racineBis, qui est le contenu de cette racine

		resultat = new ExpressionBooleenne (racineBis); // Création du resultat de la racineBis
		
		return resultat; // Retourne le resultat
	}
	
	public ExpressionBooleenne conjonction (ExpressionBooleenne expressionBooleenne) { // Création d'une ExpressionBooleenne (méthode) conjonction, qui est une conjonction (et) de l'expression booléenne
		
		ExpressionBooleenne resultat; // Resultat de l'expression booléenne
		
		boolean contenu = (this.racine.getContenu () && expressionBooleenne.racine.getContenu ()); // Contenu de la racine et le contenu de la racine de l'expressionBooleenne

		Noeud racineBis = new Noeud (contenu); // Création d'une nouvelle racineBis, qui est le contenu de cette racine

		resultat = new ExpressionBooleenne (racineBis); // Création du resultat de la racineBis
		
		return resultat; // Retourne le resultat
	}
	
	public ExpressionBooleenne negation () { // Création d'une ExpressionBooleenne (méthode) negation, qui est une négation (non) de l'expressionBooleenne
		
		ExpressionBooleenne resultat; // Resultat de l'expression booléenne
		
		if (this.racine.getContenu () == false) { // Si le contenu de la racine est faux
			
			Noeud racineBis = new Noeud (true); // Création d'une nouvelle racineBis, qui est vraie pour cette racine

			resultat = new ExpressionBooleenne (racineBis); // Création du resultat de la racineBis
		
		} else { // Sinon on retourne le resultat de la racineBis
			
			Noeud racineBis = new Noeud (false); // Création d'une nouvelle racineBis, qui est fausse pour cette racine

			resultat = new ExpressionBooleenne (racineBis); // Création du resultat de la racineBis
		}
		
		return resultat; // Retourne le resultat
	}
	
	public void ecrire () {	// Création d'une méthode ecrire, qui fait l'affichage de l'expression booléenne
		
		this.courant = this.racine; // Noeud courant est la racine de l'expression booléenne 

		ecrireReste ("Racine                             : ", this.courant); // Ecrit le reste du noeud courant de la racine 
	}
	
	public void ecrireReste (String valeur, Noeud courant){	// Création d'une methode ecrireReste avec des paramètres valeur et courant, qui parcourt le reste de l'expression booleenne 
        
        if (courant != null) { // Si le noeud courant n'est pas vide

            ecrireReste (courant + " FilsGauche : ", this.courant.getFilsGauche ()); // Ecrit le reste du noeud courant du fils gauche

            System.out.println ("\n" + valeur + this.courant.getContenu () + "\n"); // Affiche la valeur du contenu courant du noeud

            ecrireReste (courant + " FilsDroit  : ", this.courant.getFilsDroit ()); // Ecrit le reste du noeud courant du fils droit
        }
    }
	
	public boolean evaluer (boolean [] vecteurBooleen) { // Création d'un boolean (méthode) evaluer, qui évalue le vecteurBooleen de l'expression booléenne
		
		boolean resultat = (! vecteurBooleen [0]); // Resultat du premier vecteurBooleen
		
		if (estVide ()) { // Si c'est vide
			
			System.out.println ("Impossible d'evaluer l'expression booleenne !"); // Affiche impossible d'evaluer l'expression booleenne !
		
		} else { // Sinon on retourne le vecteurBooleen
			
			for (int i = 1; i < vecteurBooleen.length; i++) { // Compte la taille du vecteurBooleen
				
				if (i % 2 == 0) { // Si i est impair (0) ou paire (1) mais pas nul
					
					resultat = resultat && vecteurBooleen [i]; // Resultat du vecteurBooleen
				
				} else { // Sinon on retourne le resultat du vecteurBooleen
					
					resultat = resultat || vecteurBooleen [i]; // Resultat du vecteurBooleen 
				}
			}
		}
		
		return resultat; // Retourne le resultat
	}
}