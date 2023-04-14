import backend.controllers.TaskController;
import backend.models.Task;
import backend.seeders.TaskSeeder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TaskControllerTest {

    private static TaskController taskController;
    private static SessionFactory sessionFactory;
    private static TaskSeeder taskSeeder;

    @BeforeClass
    public static void setup() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        taskSeeder = new TaskSeeder(sessionFactory);
        taskSeeder.truncate();
        taskSeeder.seed();

        taskController = new TaskController(sessionFactory);
    }

    @AfterClass
    public static void teardown() {
        sessionFactory.close();
    }

    @Test
    public void testCreateTask() throws ClassNotFoundException {
        int taskId = taskController.create("Test Task", "This is a test task", 5, 2.5);
        Task task = taskController.getById(taskId);
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task", task.getDescription());
        assertEquals(5, task.getPoints());
        assertEquals(2.5, task.getDuration(), 0.01);
    }

    @Test
    public void testUpdateTask() throws ClassNotFoundException {
        int taskId = taskController.create("Test Task", "This is a test task", 5, 2.5);
        boolean successfullyUpdated = taskController.updateByNewData(taskId, "Updated Task", "This is an updated task", 10, 4.0);
        Task task = taskController.getById(taskId);
        assertTrue(successfullyUpdated);
        assertEquals("Updated Task", task.getName());
        assertEquals("This is an updated task", task.getDescription());
        assertEquals(10, task.getPoints());
        assertEquals(4.0, task.getDuration(), 0.01);
    }

    @Test
    public void testDeleteTask() throws ClassNotFoundException {
        int taskId = taskController.create("Test Task", "This is a test task", 5, 2.5);
        boolean successfullyDeleted = taskController.delete(taskId);
        Task deletedTaskId = taskController.getById(taskId);
        assertTrue(successfullyDeleted);
        assertNull(deletedTaskId);
    }

    @Test
    public void testGetAllTasks() {
        taskSeeder.truncate();
        taskSeeder.seed();
        List<Task> tasks = taskController.getAllModels();
        assertNotNull(tasks);
        assertEquals(3, tasks.size());
    }
}
