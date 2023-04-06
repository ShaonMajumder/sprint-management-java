import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import coma.Project;


public class HibernateExample {

    public static void main(String[] args) {
////        SessionFactory factory = new Configuration()
////                .configure("hibernate.cfg.xml")
////                .addAnnotatedClass(Project.class)
////                .buildSessionFactory();
//
//
//
//        Session session = factory.getCurrentSession();
//        System.out.println(session);



        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Project.class);

        SessionFactory sessionFactory
                = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();


        try {
            session.beginTransaction();
            List<Project> projects = null;

            projects = session.createQuery("FROM Project", Project.class).list();

            System.out.println(projects);

            for (Project project : projects) {
                System.out.println("Id: " + project.getId());
                System.out.println("Name: " + project.getName());
                System.out.println("Description: " + project.getDescription());
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();


            sessionFactory.close();
        }
    }

}
