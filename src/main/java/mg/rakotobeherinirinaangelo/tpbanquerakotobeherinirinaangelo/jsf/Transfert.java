/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.entity.CompteBancaire;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.service.GestionnaireCompte;

/**
 *
 * @author AngeloRakotobe
 */
@Named(value = "transfert")
@ViewScoped
public class Transfert implements Serializable {

    private long idSource;
    private long idDestination;
    private int somme;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public long getIdSource() {
        return idSource;
    }

    public void setIdSource(long idSource) {
        this.idSource = idSource;
    }

    public long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(long idDestination) {
        this.idDestination = idDestination;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    /**
     * Creates a new instance of Transfert
     */
    public Transfert() {
    }

    public String transfert() {
        CompteBancaire source = gestionnaireCompte.findById(idSource);
        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        this.gestionnaireCompte.transferer(source, destination, somme);
        return "listeComptes?faces-redirect=true";
    }

}
