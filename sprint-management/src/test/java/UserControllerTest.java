import BACKEND.Controllers.AuthController;
import BACKEND.Controllers.UserController;
import BACKEND.Models.User;
import BACKEND.Seeders.UserSeeder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

import static org.junit.Assert.*;

public class UserControllerTest {

    private static UserController userController;
    private static SessionFactory sessionFactory;
    private static UserSeeder userSeeder;

    @BeforeClass
    public static void setup() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        userSeeder = new UserSeeder(sessionFactory);
        userSeeder.truncate();
        userSeeder.seed();

        userController = new UserController(sessionFactory);
        String salt = BCrypt.gensalt();
        userController.setSalt(salt);
    }

    @AfterClass
    public static void teardown() {
        sessionFactory.close();
    }

    @Test
    public void testCreateUser() throws ClassNotFoundException {
        int userId = userController.create(new User("Created tester", "12345678", "testuser@test.com", "Test", "User"));
        User user = userController.getById(userId);

        assertEquals("Created tester", user.getUsername());
        assertTrue(BCrypt.checkpw("12345678", user.getPassword()));
        assertEquals("testuser@test.com", user.getEmail());
        assertEquals("Test", user.getFirstName());
        assertEquals("User", user.getLastName());
    }

    @Test
    public void testUpdateUser() throws ClassNotFoundException {
        int userId = userController.create(new User("testuser", "12345678", "testuser@test.com", "Test", "User"));
        boolean successfullyUpdated = userController.updateByNewData(userId, "updateduser", "87654321", "updateduser@test.com", "Updated", "User");
        User user = userController.getById(userId);
        assertTrue(successfullyUpdated);
        assertEquals("updateduser", user.getUsername());
        assertEquals("87654321", user.getPassword());
        assertEquals("updateduser@test.com", user.getEmail());
        assertEquals("Updated", user.getFirstName());
        assertEquals("User", user.getLastName());
    }

    @Test
    public void testDeleteUser() throws ClassNotFoundException {
        int userId = userController.create(new User("testuser", "12345678", "testuser@test.com", "Test", "User"));
        boolean successfullyDeleted = userController.delete(userId);
        User deletedUserId = userController.getById(userId);
        assertTrue(successfullyDeleted);
        assertNull(deletedUserId);
    }

    @Test
    public void testGetAllUsers() {
        userSeeder.truncate();
        userSeeder.seed();
        List<User> users = userController.getAllModels();
        assertNotNull(users);
        assertEquals(4, users.size());
    }

    @Test
    public void testAuthenticate() {
        AuthController authController = new AuthController(sessionFactory);
        int userId = userController.create(new User("userlogintest", "12345678", "test@example.com", "Test", "User"));
        User authenticatedUser = authController.authenticate("test@example.com", "12345678");

        assertNotNull(authenticatedUser);
        assertEquals(userId, authenticatedUser.getId());
        assertEquals("test@example.com", authenticatedUser.getEmail());
        assertEquals("Test", authenticatedUser.getFirstName());
        assertEquals("User", authenticatedUser.getLastName());
    }
}
