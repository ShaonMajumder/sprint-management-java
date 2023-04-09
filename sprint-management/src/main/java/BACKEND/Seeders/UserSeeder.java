package BACKEND.Seeders;

import BACKEND.Controllers.UserController;
import BACKEND.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class UserSeeder implements SeederInterface {

    private final SessionFactory sessionFactory;

    /**
     * Constructor for UserSeeder.
     *
     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
     */
    public UserSeeder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Seeds the database with sample users.
     */
    public void seed() {
        UserController userController = new UserController(sessionFactory);
        List<User> users = new ArrayList<>();
        users.add(new User("admin", BCrypt.hashpw("12345678", BCrypt.gensalt()), "admin@admin.com", "Primary", "Admin"));
        users.add(new User("turag", BCrypt.hashpw("12345678", BCrypt.gensalt()), "turag@admin.com", "Turag", "Muhaimen"));
        users.add(new User("sourav", BCrypt.hashpw("12345678", BCrypt.gensalt()), "sourav@admin.com", "Sourav", "Sur"));
        users.add(new User("shaon", BCrypt.hashpw("12345678", BCrypt.gensalt()), "shaon@admin.com", "Shaon", "Majumder"));

        // Add users to database
        for (User user : users) {
            userController.create(user);
        }
    }

    /**
     * Truncates the users table.
     */
    public void truncate() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM User");
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
