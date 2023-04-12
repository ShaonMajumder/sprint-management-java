package BACKEND.Controllers;

import BACKEND.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserController implements ControllerInterface<User>{

    private final SessionFactory sessionFactory;
    private ControllerHelper controller;

    private User user;

    public UserController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.controller = new ControllerHelper(sessionFactory);
        this.controller.setModelName("User");
    }

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void setModel(User user) {
        this.user = user;
    }

    @Override
    public List<User> getAllModels() {
        return controller.getAllModels();
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        User user = null;

        try {
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public int create(String... args) {
        String username = args[0];
        String password = args[1];
        String email = args[2];
        String firstName = args[3];
        String lastName = args[4];

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int userId = 0;

        try {
            transaction = session.beginTransaction();
            User user = new User(username, password, email, firstName, lastName);
            user.setPassword( BCrypt.hashpw( user.getPassword(), BCrypt.gensalt()) );
            userId = (int) session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userId;
    }

    @Override
    public int create(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int userId = 0;

        try {
            transaction = session.beginTransaction();
            user.setPassword( BCrypt.hashpw( user.getPassword(), BCrypt.gensalt()) );
            userId = (int) session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userId;
    }

    @Override
    public boolean updateCore(User user) {
        if (user == null) {
            System.out.println("No user selected");
            return false;
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean updated = false;

        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            updated = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return updated;
    }

    @Override
    public boolean updateByNewModel(User updatedUser) {
        return this.updateCore(updatedUser);
    }

    @Override
    public boolean updateByNewData(int userId, String... args ) {
        String newUsername = args[0];
        String newPassword = args[1];
        String newEmail = args[2];
        String newFirstName = args[3];
        String newLastName = args[4];

        User updatedUser = new User(newUsername, newPassword, newEmail, newFirstName, newLastName);
        updatedUser.setId(userId);
        return this.updateCore(updatedUser);
    }

    @Override
    public boolean update() {
        return this.updateCore(this.user);
    }
}
