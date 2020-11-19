/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author schevail
 */
public class Intervention {
    
    private final Date debut;
    private final int duree;
    private final TypeIntervention UEcours;
    private final Salle salle;
    private boolean annulee = false;
    
    public Intervention(Date debut, int duree, TypeIntervention UEcours, Salle salle){
        this.debut = debut;
        this.duree = duree;
        this.UEcours = UEcours;
        this.salle = salle;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getTypeIntervention() {
        return this.UEcours;
        
    }
    public TypeIntervention getUEcours() {
        return UEcours;
    }

    public Salle getSalle() {
        return salle;
    }

    
    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }


    
    
    
    
    
}
