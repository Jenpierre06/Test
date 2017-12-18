package fr.utt.lo02.crazyeight.model;

/**
 * 
 * Un bot est une intelligence artificielle simulant un joueur de 8 am�ricain. 
 * Un bot suit une stratgie qui repr�sente sa difficult�
 * 
 * @author antony
 *
 */
public class Bot extends Joueur {

	/**
	 * Numero du bot. Ce numero permet de diff�rencier les intelligences artificielle.
	 */
    private static int numeroBot;

    /**
     * D�fini la strat�gie de l'intelligence artificielle
     */
    private StrategieBot strategieDeJeu;

    /**
     * Getter sur le nombre de joueur artificielle
     * @return nombre positif
     */
    public int getNumeroBot() {
		return 0;
    }


    /**
     * Constructeur d'un bot.
     */
    public Bot(int nbCarte, PaquetCarte paquetDeCarte) {
		super(nbCarte, paquetDeCarte);
		this.setNom("Bot_"+numeroBot);
		Bot.numeroBot+=1;
	}


	@Override
	public String toString() {
		return "Nom: "+this.getNom()+"\nNombre de carte du "+this.getNom()+": "+this.getCarteEnMain().size();
	}


	/**
     * Setter sur la strategie utiliser par l'int�lligence artificielle.
     * @param strategie r�f�rence sur l'instance d'une strat�gie de jeu.
     */
    public void setStrategie(StrategieBot strategie) {
    	this.strategieDeJeu = strategie;
    }

    /**
     * Fais appel � la strat�gie de jeu du bot.
     */
    public void jouerStrategie(Carte derniereCarteJouer) {
    	this.strategieDeJeu.appliquerStrategie(derniereCarteJouer);
    }


}
