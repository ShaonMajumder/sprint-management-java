package BACKEND.Seeders;

import BACKEND.Controllers.RoleController;
import BACKEND.Models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RoleSeeder implements SeederInterface {

    private final SessionFactory sessionFactory;

    /**
     * Constructor for UserSeeder.
     *
     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
     */
    public RoleSeeder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Seeds the database with sample users.
     */
    public void seed() {
        RoleController roleController = new RoleController(sessionFactory);
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("Admin", "Can manage all aspects of the system"));
        roles.add(new Role("Manager", "Can manage users and projects"));
        roles.add(new Role("Developer", "Can view and update projects"));

        // Add users to database
        for (Role role : roles) {
            roleController.create(role);
        }
    }

    /**
     * Truncates the users table.
     */
    public void truncate() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Role");
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
