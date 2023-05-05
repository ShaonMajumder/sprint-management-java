
//import BACKEND.Controllers.TaskController;

import backend.controllers.ProjectController;
import backend.controllers.UserController;
import backend.models.Project;
import backend.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
//import backend.models.Task;

public class JoinExample {

    private static ProjectController projectController;

    public static void main(String[] args) throws ClassNotFoundException {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        // .addAnnotatedClass(Task.class)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // .buildSessionFactory();

        ProjectController projectController = new ProjectController(sessionFactory);
//        List<Object[]> projectData = projectController.getByIdSprint(1);

        List<Object[]> projectData = projectController.getByIdSprint(1);

        for (Object[] data : projectData) {
            System.out.println("Project: " + data[1]);
        }
//        Project: Project{id=1, name='versity project', description='null', createdAt=2023-04-21 16:56:23.0, updatedAt=null, deletedAt=null}, Sprint: Sprint{id=1, name='sprint 1', description='null', startDate=2023-04-21, endDate=2023-04-21, createdAt=2023-04-21 16:57:20.0, updatedAt=null, deletedAt=null}
//        Project: Project{id=1, name='versity project', description='null', createdAt=2023-04-21 16:56:23.0, updatedAt=null, deletedAt=null}, Sprint: Sprint{id=2, name='sprint 2', description='null', startDate=2023-04-21, endDate=2023-04-21, createdAt=2023-04-21 16:57:29.0, updatedAt=null, deletedAt=null}



        // close session factory
        sessionFactory.close();
    }

}
