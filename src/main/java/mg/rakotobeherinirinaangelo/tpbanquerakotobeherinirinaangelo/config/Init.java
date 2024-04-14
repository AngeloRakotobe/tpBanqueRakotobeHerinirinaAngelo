/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.transaction.Transactional;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.entity.CompteBancaire;
import mg.rakotobeherinirinaangelo.tpbanquerakotobeherinirinaangelo.service.GestionnaireCompte;

/**
 *
 * @author AngeloRakotobe
 */
@Named
@ApplicationScoped
public class Init {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public Init() {
    }

    @Transactional
    @PostConstruct
    public void init(@Observes
            @Initialized(ApplicationScoped.class) ServletContext context) {
        if (gestionnaireCompte.nbComptes() == 0) {
            gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrison", 100000));
        }
    }
}
