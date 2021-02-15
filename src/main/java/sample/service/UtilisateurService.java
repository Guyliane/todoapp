package sample.service;

import sample.entity.Utilisateur;
import sample.repository.UtilisateurRepository;

import java.util.List;

public class UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(){
        this.utilisateurRepository = new UtilisateurRepository();
    }

    public void userConnu(Utilisateur utilisateur) {Boolean connu = utilisateurRepository.utilisateurExistant(utilisateur);}
    public void loginUser(String username, String password){utilisateurRepository.loginUser(username, password);}
    public void createUtilisateur(Utilisateur utilisateur){utilisateurRepository.create(utilisateur);}
}
