import backend.controllers.RoleController;
import backend.models.Role;
import backend.seeders.RoleSeeder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleControllerTest {

    private static RoleController roleController;
    private static SessionFactory sessionFactory;
    private static RoleSeeder roleSeeder;

    @BeforeClass
    public static void setup() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        roleSeeder = new RoleSeeder(sessionFactory);
        roleSeeder.truncate();
        roleSeeder.seed();

        roleController = new RoleController(sessionFactory);
    }

    @AfterClass
    public static void teardown() {
        sessionFactory.close();
    }

    @Test
    public void testGetAllRoles() {
        roleSeeder.truncate();
        roleSeeder.seed();
        List<Role> roles = roleController.getAllModels();
        assertNotNull(roles);
        assertEquals(3, roles.size());
    }

    @Test
    public void testGetRoleById() throws ClassNotFoundException {
        int roleId = roleController.create("Test Role by ID", "This is a test role by ID");
        Role role = roleController.getById(roleId);
        assertNotNull(role);
        assertEquals("Test Role by ID", role.getName());
        assertEquals("This is a test role by ID", role.getDescription());
    }

    @Test
    public void testCreateRole() throws ClassNotFoundException {
        int roleId = roleController.create("Test Role", "This is a test role");
        Role role = roleController.getById(roleId);
        assertNotNull(role);
        assertEquals("Test Role", role.getName());
        assertEquals("This is a test role", role.getDescription());
    }

    @Test
    public void testUpdateRole() throws ClassNotFoundException {
        int roleId = roleController.create("Test Sprint Update", "Update This is a test sprint");
        boolean success = roleController.updateByNewData(roleId, "Updated Role", "This role has been updated");
        Role updatedRole = roleController.getById(roleId);
        assertEquals(true, success);
        assertNotNull(updatedRole);
        assertEquals("Updated Role", updatedRole.getName());
        assertEquals("This role has been updated", updatedRole.getDescription());
    }

    @Test
    public void testDeleteRole() throws ClassNotFoundException {
        int roleId = roleController.create("Test Role", "This is a test role");
        boolean successfullyDeleted = roleController.delete(roleId);
        Role role = roleController.getById(roleId);
        assertEquals(true, successfullyDeleted);
        assertNull(role);
    }
}
