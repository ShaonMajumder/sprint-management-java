package backend.seeders;

import backend.controllers.SprintController;
import backend.models.Sprint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SprintSeeder implements SeederInterface {

    private final SessionFactory sessionFactory;

    /**
     * Constructor for SprintSeeder.
     *
     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
     */
    public SprintSeeder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Seeds the database with sample sprints.
     */
    public void seed() {
        SprintController sprintController = new SprintController(sessionFactory);
        List<Sprint> sprints = new ArrayList<>();
        sprints.add(new Sprint("Sprint 1", "This is sprint 1", Date.valueOf("2023-04-12"), Date.valueOf("2023-04-20")));
        sprints.add(new Sprint("Sprint 2", "This is sprint 2", Date.valueOf("2023-04-21"), Date.valueOf("2023-04-30")));
        sprints.add(new Sprint("Sprint 3", "This is sprint 3", Date.valueOf("2023-05-01"), Date.valueOf("2023-05-08")));

        // Add sprints to database
        for (Sprint sprint : sprints) {
            sprintController.create(sprint);
        }
    }

    /**
     * Truncates the Sprint table.
     */
    public void truncate() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Sprint");
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
