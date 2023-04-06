import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import coma.Project;


public class HibernateExample {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        System.out.println(session);

        try {
            session.beginTransaction();

            List projects = session.createQuery("FROM Project").getResultList();
//            System.out.println(projects);

//            for (Project project : projects) {
//                System.out.println(project);
//            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
