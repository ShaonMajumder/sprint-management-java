
import java.util.List;
import  org.junit.*;

//import BACKEND.Controllers.TaskController;
import BACKEND.Controllers.TaskController;
import BACKEND.Controllers.UserController;
//import BACKEND.Seeders.ProjectSeeder;
import BACKEND.Models.Task;
import BACKEND.Models.User;
import BACKEND.Seeders.TaskSeeder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import BACKEND.Models.Task;

public class GetDataDBExample {

    public static void main(String[] args) throws ClassNotFoundException {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        // .addAnnotatedClass(Task.class)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // .buildSessionFactory();

//        UserController users = new UserController(sessionFactory);
//        System.out.println( users.getAllModels() );
//        User resultUser = users.getById(12);
//        System.out.println(resultUser);
//        users.delete(13);
//        users.setModel(resultUser);
//        System.out.println(users.getModel());
//        System.out.println( users.create("testusername", "12345678", "testuser@admin.com", "Test", "User"));

        TaskSeeder taskSeeder = new TaskSeeder(sessionFactory);
        taskSeeder.truncate();
        taskSeeder.seed();

        TaskController tasks = new TaskController(sessionFactory);
        System.out.println( tasks.getAllModels() );

        Task resultTask = tasks.getById(6);
        System.out.println(resultTask);

//        tasks.delete(5);
        tasks.setModel(resultTask);
        System.out.println(tasks.getModel());
        int taskId = tasks.create("Task Add", "This is task Add", 8, 4.0);
        System.out.println( taskId );
        boolean success = tasks.updateByNewData(taskId, "Task Add New task name", "New task description", 5, 2.5);
        if (success) {
            System.out.println("Task updated successfully");
        } else {
            System.out.println("Failed to update task");
        }


        // close session factory
        sessionFactory.close();
    }

}
