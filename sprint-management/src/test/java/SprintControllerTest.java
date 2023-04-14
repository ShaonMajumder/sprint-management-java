import backend.controllers.SprintController;
import backend.models.Sprint;
import backend.seeders.SprintSeeder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class SprintControllerTest {

    private static SprintController sprintController;
    private static SessionFactory sessionFactory;
    private static SprintSeeder sprintSeeder;

    @BeforeClass
    public static void setup() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        sprintSeeder = new SprintSeeder(sessionFactory);
        sprintSeeder.truncate();
        sprintSeeder.seed();

        sprintController = new SprintController(sessionFactory);
    }

    @AfterClass
    public static void teardown() {
        sessionFactory.close();
    }

    @Test
    public void testCreateSprint() throws ClassNotFoundException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date(sdf.parse("2023-04-12").getTime());
        Date endDate = new Date(sdf.parse("2023-04-20").getTime());

        int sprintId = sprintController.create("Test Sprint", "This is a test sprint", startDate, endDate);
        Sprint sprint = sprintController.getById(sprintId);

        assertNotNull(sprint);
        assertEquals("Test Sprint", sprint.getName());
        assertEquals("This is a test sprint", sprint.getDescription());
        assertEquals(startDate, sprint.getStartDate());
        assertEquals(endDate, sprint.getEndDate());
    }

    @Test
    public void testUpdateSprint() throws ClassNotFoundException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date(sdf.parse("2023-04-12").getTime());
        Date endDate = new Date(sdf.parse("2023-04-20").getTime());

        int sprintId = sprintController.create("Test Sprint", "This is a test sprint", startDate, endDate);

        boolean success = sprintController.updateByNewData(sprintId, "Updated Sprint", "This is an updated sprint",
                new Date(sdf.parse("2023-04-15").getTime()), new Date(sdf.parse("2023-04-22").getTime()));
        Sprint sprint = sprintController.getById(sprintId);

        assertEquals(true, success);
        assertEquals("Updated Sprint", sprint.getName());
        assertEquals("This is an updated sprint", sprint.getDescription());
        assertEquals(new Date(sdf.parse("2023-04-15").getTime()), sprint.getStartDate());
        assertEquals(new Date(sdf.parse("2023-04-22").getTime()), sprint.getEndDate());
    }

    @Test
    public void testDeleteSprint() throws ClassNotFoundException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date(sdf.parse("2023-04-12").getTime());
        Date endDate = new Date(sdf.parse("2023-04-20").getTime());

        int sprintId = sprintController.create("Test Sprint", "This is a test sprint", startDate, endDate);
        boolean successfullyDeleted = sprintController.delete(sprintId);
        Sprint sprint = sprintController.getById(sprintId);
        assertEquals(true, successfullyDeleted);
        assertNull(sprint);
    }

    @Test
    public void testGetAllSprints() throws ClassNotFoundException {
        sprintSeeder.truncate();
        sprintSeeder.seed();
        List<Sprint> sprints = sprintController.getAllModels();
        assertNotNull(sprints);
        assertEquals(3, sprints.size());
    }
}
