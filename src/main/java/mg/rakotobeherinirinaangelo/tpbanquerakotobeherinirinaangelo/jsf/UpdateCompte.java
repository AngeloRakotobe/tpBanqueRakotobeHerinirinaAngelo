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
    private String ancienNom;
    private String nouveauNom;

    public String getAncienNom() {
        return ancienNom;
    }

    public void setAncienNom(String ancienNom) {
        this.ancienNom = ancienNom;
    }

    public String getNouveauNom() {
        return nouveauNom;
    }

    public void setNouveauNom(String nouveauNom) {
        this.nouveauNom = nouveauNom;
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
        this.compte = gestionnaireCompte.findById(idCompte);
        ancienNom= compte.getNom();
    }

    public String modifierCompte() {
        compte.setNom(nouveauNom);
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Modifications enregistrées");
        Util.addFlashInfoMessage("Le nom "
                + this.ancienNom
                + " changé en "
                + this.nouveauNom);
        return "listeComptes?faces-redirect=true";
    }
}
