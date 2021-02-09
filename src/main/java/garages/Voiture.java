package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

    private final String immatriculation;
    private final List<Stationnement> myStationnements = new LinkedList<>();

    public Voiture(String i) {
        if (null == i) {
            throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
        }

        immatriculation = i;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Fait rentrer la voiture au garage Précondition : la voiture ne doit pas
     * être déjà dans un garage
     *
     * @param g le garage où la voiture va stationner
     * @throws java.lang.Exception Si déjà dans un garage
     */
    public void entreAuGarage(Garage g) throws Exception {
        for (Stationnement s : myStationnements){
            if (s.estEnCours()) {
                throw new Exception ("La voiture est déjà dans un garage.");
            }
        }
        Stationnement s = new Stationnement(this, g);
        myStationnements.add(s);
    }

    /**
     * Fait sortir la voiture du garage Précondition : la voiture doit être dans
     * un garage
     *
     * @throws java.lang.Exception si la voiture n'est pas dans un garage
     */
    public void sortDuGarage() throws Exception {
        int nb = 0 ;
        for (Stationnement s : myStationnements) {
            if (s.estEnCours()) {
                s.terminer();
            nb ++ ; 
            }
        }
        if (nb == 0) throw new Exception("La voiture n'est dans aucuns garage.");
    }

    /**
     * @return l'ensemble des garages visités par cette voiture
     */
    public Set<Garage> garagesVisites() {
        HashSet<Garage> ret = new HashSet<Garage>();
        for (Stationnement s : myStationnements) {
            ret.add(s.getGarage());
        }
        return ret;
    }

    /**
     * @return vrai si la voiture est dans un garage, faux sinon
     */
    public boolean estDansUnGarage() {
// TODO: Implémenter cette méthode
        for (Stationnement s : myStationnements) {
            if (s.estEnCours()) {
                return true;
            }
        }
        return false;
        // Vrai si le dernier stationnement est en cours
    }

    /**
     * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste
     * des dates d'entrée / sortie dans ce garage
     * <br>Exemple :
     * <pre>
     * Garage Castres:
     *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     *		Stationnement{ entree=28/01/2019, en cours }
     *  Garage Albi:
     *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     * </pre>
     *
     * @param out l'endroit où imprimer (ex: System.out)
     */
    public void imprimeStationnements(PrintStream out) {
// TODO: Implémenter cette méthode
        //System.out.println( "" +Garage+ "" +entreAuGarage.list+ "," +sortDuGarage.list+ "" );
    }

}
