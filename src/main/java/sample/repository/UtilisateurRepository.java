package sample.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sample.entity.Utilisateur;
import sample.service.HibernateUtil;

import java.util.List;

public class UtilisateurRepository {

    public boolean utilisateurExistant(Utilisateur utilisateur){
        Session session = null;
        Transaction tc = null;

        //Si les champs sont renseignés, regrder en base parmis la liste des user si les identifiants sont connus.

        session = HibernateUtil.getSessionFactory().openSession();
        Query<Utilisateur> query = session.createQuery("select u from Utilisateur u", Utilisateur.class);
        List<Utilisateur> utilisateurs = query.getResultList();
        //return utilisateurs;
        if(!utilisateur.getPseudo().equals("") || !utilisateur.getMotdepasse().equals("")){
            //String query = "SELECT * FROM utilisateurs WHERE utilisateurs.nom =? AND utilisateurs.motdepasse =?";
        }
        return false;
    }

    public void loginUser(String username, String password){
        //Regarder si l'utilisateur existe dans la bdd
        if(!username.equals("") || !password.equals("")){

        }else
        {
            //Erreur, entrer les informations de connexions
        }

    }

    public void create(Utilisateur utilisateur){
        Session session = null;
        Transaction tc = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tc = session.beginTransaction();
            session.persist(utilisateur);
            tc.commit();


            System.out.println("Utilisateur ajouté");

        } catch (Exception e) {
            if(tc!=null)
            {
                tc.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(session!=null)
            {
                session.close();
            }
        }
    }
}
