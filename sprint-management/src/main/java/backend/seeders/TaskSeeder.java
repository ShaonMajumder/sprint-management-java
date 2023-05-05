package backend.seeders;

import backend.controllers.TaskController;
import backend.models.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TaskSeeder implements SeederInterface {

    private final SessionFactory sessionFactory;

    /**
     * Constructor for TaskSeeder.
     *
     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
     */
    public TaskSeeder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Seeds the database with sample tasks.
     */
    public void seed() {
        TaskController taskController = new TaskController(sessionFactory);
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "This is task 11", 5, 2.5));
        tasks.add(new Task("Task 2", "This is task 2", 10, 5.0));
        tasks.add(new Task("Task 3", "This is task 3", 8, 4.0));

        // Add tasks to database
        for (Task task : tasks) {
            taskController.create(task);
        }
    }

    public void truncate() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Task");
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
