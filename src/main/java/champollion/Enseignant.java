package champollion;

import static java.lang.Math.round;
import java.util.HashSet;

public class Enseignant extends Personne {

    private HashSet<ServicePrevu> lesEnseignements = new HashSet<>();
    private HashSet<Intervention> lesInterventions = new HashSet<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        float compteur = 0;
        for (ServicePrevu sp : lesEnseignements){
            compteur += (sp.getVolumeCM()*1.5 + sp.getVolumeTD() + sp.getVolumeTP()*0.75);
        }
        return round(compteur);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        float compteur = 0;
        for (ServicePrevu sp : lesEnseignements){
            if (sp.getUe() == ue){
                compteur += (sp.getVolumeCM()*1.5 + sp.getVolumeTD() + sp.getVolumeTP()*0.75);
            }
        }
        return round(compteur);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        lesEnseignements.add(new ServicePrevu(ue, volumeCM, volumeTD, volumeTP));
    }
    
    /**
     * Ajoute une intervention planifiée pour cet enseignant
     * @param interv l'intervention concernée
     * 
    */
    public void ajouteIntervention(Intervention interv){
        lesInterventions.add(interv);
    }
    
    public int heuresPlanifiees(){
        float compteur = 0;
        for (Intervention interv : lesInterventions){
            if (interv.getTypeIntervention() == null){
                compteur += interv.getDuree();
            } else switch (interv.getTypeIntervention()){
                case CM:
                    compteur += (interv.getDuree() * 1.5);
                    break;
                case TP:
                    compteur += (interv.getDuree() * 0.75);
                    break;
                default:
                    compteur += interv.getDuree();
                    break;
            }
        }
        return round(compteur);
    }

    public boolean enSousService(){
        return this.heuresPlanifiees() < this.heuresPrevues();
    }
}
