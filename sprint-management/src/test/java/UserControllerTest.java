import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import BACKEND.Controllers.UserController;
import BACKEND.Models.User;
import BACKEND.Seeders.UserSeeder;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.Assert.assertEquals;

public class UserControllerTest {

    private static UserController userController;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setup() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        UserSeeder userSeeder = new UserSeeder(sessionFactory);
        userSeeder.truncate();
        userSeeder.seed();

        userController = new UserController(sessionFactory);
    }

    @AfterClass
    public static void teardown() {
        sessionFactory.close();
    }

    @Test
    public void testCreateUser() throws ClassNotFoundException {
        String salt =  BCrypt.gensalt();
        userController.setSalt(salt);
        int userId = userController.create(new User("tester", "12345678", "testuser@test.com", "Test", "User"));
        User user = userController.getById(userId);
        String hashedPassword = BCrypt.hashpw("12345678", salt);

        assertEquals("tester", user.getUsername());
        assertEquals(BCrypt.checkpw("12345678",user.getPassword()), true);
        assertEquals("testuser@test.com", user.getEmail());
        assertEquals("Test", user.getFirstName());
        assertEquals("User", user.getLastName());
    }

    @Test
    public void testUpdateUser() throws ClassNotFoundException {
        int userId = userController.create(new User("testuser", "12345678", "testuser@test.com", "Test", "User"));
        boolean success = userController.updateByNewData(userId, "updateduser", "87654321", "updateduser@test.com", "Updated", "User");
        User user = userController.getById(userId);
        assertEquals(true, success);
        assertEquals("updateduser", user.getUsername());
        assertEquals("87654321", user.getPassword());
        assertEquals("updateduser@test.com", user.getEmail());
        assertEquals("Updated", user.getFirstName());
        assertEquals("User", user.getLastName());
    }

    @Test
    public void testDeleteUser() throws ClassNotFoundException {
        int userId = userController.create(new User("testuser", "12345678", "testuser@test.com", "Test", "User"));
        boolean success = userController.delete(userId);
        User user = userController.getById(userId);
        assertEquals(true, success);
        assertEquals(null, user);
    }
}
