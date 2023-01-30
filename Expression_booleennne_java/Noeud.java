public class Noeud { // Création d'une class Noeud

    private boolean contenu; // Contenu du noeud

    public Noeud filsGauche; // Noeud du fils gauche 
    public Noeud filsDroit; // Noeud du fils droit
    
    private Noeud parent; // Noeud du parents

    public Noeud (boolean contenu) { // Création d'un constructeur du Noeud avec un paramètre contenu, qui est le contenu du noeud
            
        this.contenu = contenu; // Contenu du noeud

        this.filsGauche = null; // Noeud du fils gauche est vide
        this.filsDroit = null; // Noeud du fils droit est vide
        this.parent = null; // Noeud du parent est vide
    }

    public Noeud (boolean contenu, Noeud parent) { // Création d'un constructeur du Noeud avec des paramètres contenu et parent, qui sont le contenu du noeud du parent
            
        this.contenu = contenu; // Contenu du noeud

        this.filsGauche = null; // Noeud du fils gauche est vide
        this.filsDroit = null; // Noeud du fils droit est vide
        this.parent = null; // Noeud du parent est vide
    }
    
    public boolean getContenu () { // Création d'un accesseur Contenu, qui retourne le contenu du noeud
    	
    	return this.contenu;
    }

    public void setContenu (boolean booleen) { // Création d'une méthode Contenu, qui modifie le booléen avec le paramètre booleen

    	this.contenu = booleen;
    }
    
    public Noeud getFilsGauche () { // Création d'un accesseur FilsGauche, qui retourne le fils gauche du noeud
    	
    	return this.filsGauche;
    }

    public void setFilsGauche (Noeud noeud) { // Création d'une méthode FilsGauche, qui modifie le noeud avec le paramètre noeud
    	
    	this.filsGauche = new Noeud (noeud.getContenu (), this);
    }
    
    public Noeud getFilsDroit () { // Création d'un accesseur FilsGauche, qui retourne le fils droit du noeud
    	
    	return this.filsDroit;
    }

    public void setFilsDroit (Noeud noeud) { // Création d'une méthode FilsDroit, qui modifie le noeud avec le paramètre noeud
    	
    	this.filsDroit = new Noeud (noeud.getContenu (), this);
    }

    public Noeud getParent () { // Création d'un accesseur Parent, qui retourne le parent du noeud
	
    	return this.parent;
    }

    public String toString () { // Création d'un String (méthode) toString, qui affiche le noeud sous forme de chaine de caractère
        
        return "" + this.contenu; // Retourne le contenu du noeud
    }
}