package BACKEND.Seeders;

import BACKEND.Controllers.ProjectController;
import BACKEND.Models.Project;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProjectSeeder {

    private final SessionFactory sessionFactory;

    /**
     * Constructor for ProjectSeeder.
     * 
     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
     */
    public ProjectSeeder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Seeds the database with sample projects.
     */
    public void seed() {
        ProjectController projectController = new ProjectController(sessionFactory);

        // Create sample projects
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Project 1", "This is project 1"));
        projects.add(new Project("Project 2", "This is project 2"));
        projects.add(new Project("Project 3", "This is project 3"));

        // Add projects to database
        for (Project project : projects) {
            projectController.create(project);
        }
    }
}