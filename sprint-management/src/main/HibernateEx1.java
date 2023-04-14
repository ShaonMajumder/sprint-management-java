import UI.Home;
import UI.LoginWindow;
import UI.ProjectCreate;
import UI.ProjectList;
import backend.models.Project;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateEx1 {

    public static void matein(String[] args) {
        LoginWindow.draw();
        Home.draw();
        ProjectCreate.draw();
        ProjectList.draw();

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();

        // Session session = factory.getCurrentSession();

        try {
            // session.beginTransaction();
            List<Project> projectsa = null;
            Project projects = new Project();
//            projectsa = projects.getProjects((SessionFactory) factory);

//            System.out.println(projectsa);

            // session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // session.close();

            factory.close();
        }
    }

}
