/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.entity.CompteBancaire;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.service.GestionnaireCompte;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.util.Util;

/**
 *
 * @author AngeloRakotobe
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    private List<CompteBancaire> compteBancaireList;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (compteBancaireList == null) {
            compteBancaireList = gestionnaireCompte.getAllComptes();
        }
        return compteBancaireList;
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        gestionnaireCompte.delete(compteBancaire);
        Util.addFlashInfoMessage("Le compte de "
                + compteBancaire.getNom()
                + " a été supprimé");
        return "listeComptes?faces-redirect=true";
    }
}
