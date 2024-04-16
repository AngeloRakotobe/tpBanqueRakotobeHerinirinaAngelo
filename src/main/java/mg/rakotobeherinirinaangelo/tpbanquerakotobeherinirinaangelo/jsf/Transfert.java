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
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.util.Util;

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
        boolean erreur = false;
        CompteBancaire source = gestionnaireCompte.findById(idSource);
        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        if (source == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
            erreur = true;
        } else {
            if (source.getSolde() < somme) { // à compléter pour le cas où le solde du compte source est insuffisant...
                Util.messageErreur("Solde du compte insuffisant!", "Solde insuffisant!", "form:somme");
                erreur = true;
            }
        }
        if (destination == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
            erreur = true;
        }
        if (erreur) {
            return null;
        }
        this.gestionnaireCompte.transferer(source, destination, somme);

        Util.addFlashErrorMessage("Le montant de "
                + this.somme
                + " a correctement été transféré depuis le compte de "
                + source.getNom()
                + " à celui de "
                + destination.getNom());
        return "listeComptes?faces-redirect=true";
    }

}
