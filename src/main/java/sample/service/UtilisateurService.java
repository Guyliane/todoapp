package sample.service;

import sample.entity.Utilisateur;
import sample.repository.UtilisateurRepositoryImpl;

public class UtilisateurService {
    private UtilisateurRepositoryImpl utilisateurRepository;

    public UtilisateurService(){
        this.utilisateurRepository = new UtilisateurRepositoryImpl();
    }

    public void inscrireUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.create(utilisateur);
    }
}
