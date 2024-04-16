/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.PositiveOrZero;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.entity.CompteBancaire;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.service.GestionnaireCompte;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.util.Util;

/**
 *
 * @author AngeloRakotobe
 */
@Named(value = "ajoutCompte")
@ApplicationScoped
public class AjoutCompte {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private String nom;

    @PositiveOrZero
    private int solde;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String nouveauCompte() {
        CompteBancaire compteBancaire = new CompteBancaire(nom, solde);
        gestionnaireCompte.creerCompte(compteBancaire);
        Util.addFlashInfoMessage("Le compte de "
                + nom
                + " a été bien créé avec un solde inital de "
                + solde);
        return "listeComptes?faces-redirect=true";
    }
}
