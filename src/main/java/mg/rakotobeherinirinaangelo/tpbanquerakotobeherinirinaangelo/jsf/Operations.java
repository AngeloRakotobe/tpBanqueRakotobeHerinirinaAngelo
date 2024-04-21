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
@Named(value = "operations")
@ViewScoped
public class Operations implements Serializable {

    @Inject
    private GestionnaireCompte gestionnaireCompte;
    private Long idCompte;
    private CompteBancaire compte;

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public CompteBancaire getCompteBancaire() {
        return compte;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compte = compteBancaire;
    }

    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }

    public void recupererCompte() {
        compte = gestionnaireCompte.findById(idCompte);
    }
}
