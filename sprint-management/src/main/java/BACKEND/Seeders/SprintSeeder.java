//package BACKEND.Seeders;
//
//import BACKEND.Seeders.SeederInterface;
//import BACKEND.Controllers.SprintController;
//import BACKEND.Models.Sprint;
//import org.hibernate.SessionFactory;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SprintSeeder implements SeederInterface {
//
//    private final SessionFactory sessionFactory;
//
//    /**
//     * Constructor for SprintSeeder.
//     *
//     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
//     */
//    public SprintSeeder(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    /**
//     * Seeds the database with sample sprints.
//     */
//    public void seed() {
//        SprintController sprintController = new SprintController(sessionFactory);
//        List<Sprint> sprints = new ArrayList<>();
//        sprints.add(new Sprint("Sprint 1", LocalDate.now(), LocalDate.now().plusDays(14)));
//        sprints.add(new Sprint("Sprint 2", LocalDate.now().plusDays(21), LocalDate.now().plusDays(35)));
//        sprints.add(new Sprint("Sprint 3", LocalDate.now().plusDays(42), LocalDate.now().plusDays(56)));
//
//        // Add sprints to database
//        for (Sprint sprint : sprints) {
//            sprintController.create(sprint);
//        }
//    }
//}
