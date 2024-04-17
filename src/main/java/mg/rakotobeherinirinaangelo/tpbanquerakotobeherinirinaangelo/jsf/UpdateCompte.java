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
@Named(value = "updateCompte")
@ViewScoped
public class UpdateCompte implements Serializable {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private Long idCompte;
    private CompteBancaire compte;
    private String nomCompte;

    public String getNomCompte() {
        return nomCompte;
    }

    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    /**
     * Creates a new instance of UpdateNomCompte
     */
    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public UpdateCompte() {
    }

    public void loadCompte() {
        compte = gestionnaireCompte.findById(idCompte);
        nomCompte = compte.getNom();
    }

    public String modifierCompte() {
        String ancienNom = compte.getNom();
        compte.setNom(nomCompte);
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Modifications enregistrées");
        Util.addFlashInfoMessage("Le nom "
                + ancienNom
                + " changé en "
                + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }
}
