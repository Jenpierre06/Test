package fr.utt.lo02.crazyeight.model;

/**
 * La classe carte repr�sente une carte de jeu de 8 am�ricain.
 * @author antony
 *
 */
public class Carte {

	/* Deplacer dans les effects de cartes
	 * Point de la carte
	 
    private int point;
    */
	
	private int valeur;
	
    /**
     * Famille de la carte
     */
    private EnumerationFamille famille;
    
    /**
     * Couleur de la carte
     */
    private EnumeartionCouleur color;
    
    /**
     * R�f�rence � l'�ffet associer � la carte
     */
    private IEffetDeCarte effetCarte;
    
    /**
     * Indique si l'effet de la carte doit s'appliquer
     */
    private boolean effetAnnule;
    
    /**
     * Paquet de carte ou la carte a �t� cr��e
     */
    private PaquetCarte paquet;
    
    /**
     * Nom attribu� � la carte
     */
    private String nomCarte;
    
    //private int valeur; Cette attibu est dans la class normale

    
    /**
     * Constructeur d'une carte.
     * @param famille est la famille de la carte
     * @param point est le nombre de point que g�n�re la carte
     * @param nom est le nom de la carte
     */
    public Carte(EnumerationFamille famille, String nom) {
    	this.nomCarte = nom;
    	this.famille = famille;
    	this.effetAnnule = false;
    	
    	if (this.famille == EnumerationFamille.carreau || this.famille == EnumerationFamille.coeur)
    		this.color = EnumeartionCouleur.rouge;
    	else 
    		this.color = EnumeartionCouleur.noir;
    	
    }
    
    public boolean isEffetAnnule() {
		return this.effetAnnule;
	}

	public void setEffetAnnule(boolean effetAnnule) {
		this.effetAnnule = effetAnnule;
	}

	public IEffetDeCarte getEffetCarte() {
		return this.effetCarte;
	}

	public void setEffetCarte(IEffetDeCarte effetCarte) {
		this.effetCarte = effetCarte;
	}

	@Override
	public String toString() {
		return "["+this.nomCarte+":"+this.famille+":"+this.color+"]";
	}

	/**
     * Associe une instance d'un effet � la carte en fonction de la variante du paquet de carte
     */
    public void attribuerEffet(EnumerationVariante varianteUtiliser) {
    	switch(varianteUtiliser) {
    		case Normal:
    			this.effetCarte = new EffetVarainteNormale();
    		break;
    	}
    }

    /**
     * Setter sur la couleur de la carte.
     * @param c est un boolean. Si "c" est � 1 la carte est rouge, sinon elle est noir
     */
    public void setColor(EnumeartionCouleur c) {
    	this.color = c;
    }

    public EnumeartionCouleur getColor() {
		return color;
	}

	/**
     * Appliquer les effets associ� � la carte � un joueur.
     */
    public void utiliserEffet(Joueur joueurAffecte, Partie partieAffecte) {
    	this.effetCarte.appliquerEffet(joueurAffecte, partieAffecte);
    }
    
    /**
     * Getter sur la famille de la carte.
     * @return Le nom de la famille
     */
    public EnumerationFamille getFamille() {
		return this.famille;
    }

	public String getNomCarte() {
		return this.nomCarte;
	}

	public void setFamille(EnumerationFamille famille) {
		this.famille = famille;
	}

	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}

}
