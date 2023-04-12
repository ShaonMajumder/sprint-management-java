import BACKEND.Controllers.AuthController;
import BACKEND.Controllers.TaskController;
import BACKEND.Models.User;
import BACKEND.Seeders.ProjectSeeder;
import BACKEND.Seeders.SprintSeeder;
import BACKEND.Seeders.RoleSeeder;
import BACKEND.Seeders.TaskSeeder;
import BACKEND.Seeders.PermissionSeeder;

import BACKEND.Seeders.UserSeeder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Seeder {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        // .addAnnotatedClass(Task.class)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // .buildSessionFactory();

//        ProjectSeeder projectSeeder = new ProjectSeeder(sessionFactory);
//        SprintSeeder sprintSeeder = new SprintSeeder(sessionFactory);
//        TaskSeeder taskSeeder = new TaskSeeder(sessionFactory);
//        UserSeeder userSeeder = new UserSeeder(sessionFactory);
//        RoleSeeder roleSeeder = new RoleSeeder(sessionFactory);
//        PermissionSeeder permissionSeeder = new PermissionSeeder(sessionFactory);
//
////        projectSeeder.seed();
////        projectSeeder.truncate();
//
////         sprintSeeder.seed();
////         taskSeeder.seed();
//        userSeeder.truncate();
//         userSeeder.seed();
//        // roleSeeder.seed();
//
//        AuthController authController = new AuthController(sessionFactory);
//        User auth = authController.authenticate( "shaon@admin.com", "12345678");
//        System.out.println(auth);
//
////        permissionSeeder.truncate();
//
//        // userSeeder.seed();
//        // roleSeeder.seed();

        // close session factory
        sessionFactory.close();
    }

}
