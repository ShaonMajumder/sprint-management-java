import backend.controllers.ProjectController;
import backend.models.Project;
import backend.seeders.ProjectSeeder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectControllerTest {

    private static ProjectController projectController;
    private static SessionFactory sessionFactory;
    private static ProjectSeeder projectSeeder;

    @BeforeClass
    public static void setup() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        projectSeeder = new ProjectSeeder(sessionFactory);
        projectSeeder.truncate();
        projectSeeder.seed();

        projectController = new ProjectController(sessionFactory);
    }

    @AfterClass
    public static void teardown() {
        sessionFactory.close();
    }

    @Test
    public void testCreateProject() throws ClassNotFoundException, ParseException {
        int projectId = projectController.create("Test Project", "This is a test project");
        Project project = projectController.getById(projectId);

        assertNotNull(project);
        assertEquals("Test Project", project.getName());
        assertEquals("This is a test project", project.getDescription());
    }

    @Test
    public void testUpdateProject() throws ClassNotFoundException, ParseException {
        int projectId = projectController.create("Test Project", "This is a test project");
        boolean successfullyUpdated = projectController.updateByNewData(projectId, "Updated Project", "This is an updated project");
        Project project = projectController.getById(projectId);

        assertEquals(true, successfullyUpdated);
        assertEquals("Updated Project", project.getName());
        assertEquals("This is an updated project", project.getDescription());
    }

    @Test
    public void testDeleteProject() throws ClassNotFoundException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp createdAt = new Timestamp(sdf.parse("2023-04-12 12:00:00").getTime());

        int projectId = projectController.create("Test Project", "This is a test project", createdAt);
        boolean success = projectController.delete(projectId);
        Project project = projectController.getById(projectId);
        assertEquals(true, success);
        assertNull(project);
    }
}
