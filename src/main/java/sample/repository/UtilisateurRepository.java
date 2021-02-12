package sample.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.entity.Utilisateur;
import sample.service.HibernateUtil;

public class UtilisateurRepository {
    public void loginUser(String username, String password){
        //Regarder si l'utilisateur existe dans la bdd

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
