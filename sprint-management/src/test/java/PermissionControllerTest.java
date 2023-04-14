import backend.controllers.PermissionController;
import backend.models.Permission;
import backend.seeders.PermissionSeeder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PermissionControllerTest {

    private static PermissionController permissionController;
    private static SessionFactory sessionFactory;
    private static PermissionSeeder permissionSeeder;

    @BeforeClass
    public static void setup() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        permissionSeeder = new PermissionSeeder(sessionFactory);
        permissionSeeder.truncate();
        permissionSeeder.seed();

        permissionController = new PermissionController(sessionFactory);
    }

    @AfterClass
    public static void teardown() {
        sessionFactory.close();
    }

    @Test
    public void testCreatePermission() throws ClassNotFoundException {
        int permissionId = permissionController.create("test", "test permission");
        Permission permission = permissionController.getById(permissionId);

        assertNotNull(permission);
        assertEquals("test", permission.getName());
        assertEquals("test permission", permission.getDescription());
    }

    @Test
    public void testUpdatePermission() throws ClassNotFoundException {
        Permission permission = permissionController.getAllModels().get(0);
        permission.setName("updated test");
        permission.setDescription("updated test permission");
        assertTrue(permissionController.updateCore(permission));

        Permission updatedPermission = permissionController.getById(permission.getId());
        assertNotNull(updatedPermission);
        assertEquals("updated test", updatedPermission.getName());
        assertEquals("updated test permission", updatedPermission.getDescription());
    }

    @Test
    public void testDeletePermission() throws ClassNotFoundException {
        List<Permission> permissionsBeforeDelete = permissionController.getAllModels();
        int permissionIdToDelete = permissionsBeforeDelete.get(permissionsBeforeDelete.size() - 1).getId();
        assertTrue(permissionController.delete(permissionIdToDelete));

        List<Permission> permissionsAfterDelete = permissionController.getAllModels();
        assertNull(permissionController.getById(permissionIdToDelete));
        assertEquals(permissionsBeforeDelete.size() - 1, permissionsAfterDelete.size());
    }

    @Test
    public void testGetAllPermissions() throws ClassNotFoundException {
        permissionSeeder.truncate();
        permissionSeeder.seed();
        List<Permission> permissions = permissionController.getAllModels();
        assertNotNull(permissions);
        assertEquals(3, permissions.size());
    }
}
