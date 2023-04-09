package BACKEND.Controllers;

import BACKEND.Models.Project;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ProjectController implements ControllerInterface {

    private final SessionFactory sessionFactory;
    private Project project;

    /**
     * Constructor for ProjectController.
     * 
     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
     */
    public ProjectController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Gets the currently selected Project.
     * 
     * @return The currently selected Project.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the currently selected Project.
     * 
     * @param project The Project to set as the currently selected Project.
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Retrieves all Projects from the database.
     * 
     * @return A List of all Projects in the database.
     */
    public List<Project> getAllProjects() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Project> projects = null;

        try {
            transaction = session.beginTransaction();
            projects = session.createQuery("from Project").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return projects;
    }

    /**
     * Retrieves a Project by its ID.
     * 
     * @param id The ID of the Project to retrieve.
     * @return The Project with the specified ID, or null if no such Project exists.
     */
    public Project getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Project project = null;

        try {
            transaction = session.beginTransaction();
            project = session.get(Project.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return project;
    }

    /**
     * Creates a new project with the specified name and description.
     *
     * @param name        The name of the project.
     * @param description The description of the project.
     * @return The ID of the newly created project.
     */
    public int create(String name, String description) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int projectId = 0;

        try {
            transaction = session.beginTransaction();
            Project project = new Project(name, description);
            projectId = (int) session.save(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return projectId;
    }

    /**
     * Creates a new project with the specified name and description.
     *
     * @param name        The name of the project.
     * @param description The description of the project.
     * @return The ID of the newly created project.
     */
    public int create(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int projectId = 0;

        try {
            transaction = session.beginTransaction();
            projectId = (int) session.save(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return projectId;
    }

    @Override
    public boolean updateCore(Object project) {
        if (project instanceof Project) {
            System.out.println("obj is not an instance of Project");
            return false;
        }

        if (project == null) {
            System.out.println("No project selected");
            return false;
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean updated = false;

        try {
            transaction = session.beginTransaction();
            session.update(project);
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

    public boolean updateByNewModel(Project updatedProject) {
        return this.updateCore(updatedProject);
    }

    public boolean updateByNewData(int projectId, String newProjectName, String newDescription) {
        Project updatedProject = new Project(newProjectName, newDescription);
        updatedProject.setId(projectId);
        return this.updateCore(updatedProject);
    }

    public boolean update() {
        return this.updateCore(this.project);
    }

    /**
     * Deletes a project by its ID.
     *
     * @param id The ID of the project to delete.
     * @return true if the project was deleted successfully, false otherwise.
     */
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            Project project = session.get(Project.class, id);
            if (project != null) {
                session.delete(project);
                transaction.commit();
                deleted = true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return deleted;
    }

    /**
     * Deletes a project.
     *
     * @param paramProject The project to delete.
     * @return true if the project was deleted successfully, false otherwise.
     */
    public boolean delete(Project paramProject) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            Project project = session.get(Project.class, paramProject.getId());
            if (project != null) {
                session.delete(project);
                transaction.commit();
                deleted = true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return deleted;
    }

    /**
     * 
     * Deletes the currently selected project.
     * 
     * @return true if the project was successfully deleted, false otherwise
     */
    public boolean delete() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            Project project = session.get(Project.class, this.project.getId());
            if (project != null) {
                session.delete(project);
                transaction.commit();
                deleted = true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return deleted;
    }
}
