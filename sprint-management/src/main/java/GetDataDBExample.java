import java.util.List;

//import BACKEND.Controllers.TaskController;
import BACKEND.Controllers.UserController;
//import BACKEND.Seeders.ProjectSeeder;
import BACKEND.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import BACKEND.Models.Task;

public class GetDataDBExample {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        // .addAnnotatedClass(Task.class)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // .buildSessionFactory();


        UserController users = new UserController(sessionFactory);

//        System.out.println( users.getAllModels() );
        User resultUser = users.getById(12);
        users.setModel(resultUser);
        System.out.println(users.getModel());

//        System.out.println( users.create("testusername", "12345678", "testuser@admin.com", "Test", "User"));
        // close session factory
        sessionFactory.close();
    }

}
