package sample.service;

import sample.repository.UtilisateurRepository;

public class UtilisateurService {
    UtilisateurRepository utilisateurRepository = null;

    public void loginUser(String username, String password){utilisateurRepository.loginUser(username, password);}
}
