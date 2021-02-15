import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import sample.entity.Utilisateur;


public class UtilisateurRepositoryTest {
/*
    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    public void testCreate() {
        System.out.println("Running testCreate...");

        session.beginTransaction();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom("Guyliane");
        utilisateur.setNom("Pimenta");
        utilisateur.setPseudo("Nyarout");
        utilisateur.setMotdepasse("popo");
        utilisateur.setSexe("Homme");
        Integer id = (Integer) session.save(utilisateur);

        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testList() {
    }

    @Test
    public void testDelete() {
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }*/
}
