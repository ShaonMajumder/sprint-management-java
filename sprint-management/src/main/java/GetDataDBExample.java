import java.util.List;

import BACKEND.Controllers.TaskController;
import BACKEND.Seeders.ProjectSeeder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import BACKEND.Models.Task;

public class GetDataDBExample {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        // .addAnnotatedClass(Task.class)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // .buildSessionFactory();

        // create an instance of the TaskController
        TaskController taskController = new TaskController(sessionFactory);
        ProjectSeeder projectSeeder = new ProjectSeeder(sessionFactory);

        projectSeeder.seed();

        // close session factory
        sessionFactory.close();
    }

}
