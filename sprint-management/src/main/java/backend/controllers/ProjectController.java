package backend.controllers;

import backend.models.Project;
import backend.models.Sprint;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectController implements ControllerInterface<Project> {

    private final SessionFactory sessionFactory;
    private final ControllerHelper controller;

    private Project project;

    public ProjectController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.controller = new ControllerHelper(sessionFactory);
        this.controller.setModelName("Project");
    }

    @Override
    public Project getModel() {
        return project;
    }

    @Override
    public void setModel(Project project) {
        this.project = project;
    }

    @Override
    public List<Project> getAllModels() {
        return controller.getAllModels();
    }

    @Override
    public Project getById(int id) throws ClassNotFoundException {
        return (Project) controller.getById(id);
    }

    @Override
    public int create(Object... args) {
        if (args.length < 2) {
            System.out.println("Insufficient arguments provided");
            return -1;
        }

        String name = (String) args[0];
        String description = (String) args[1];

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int projectId = 0;

        try {
            transaction = session.beginTransaction();
            Project project = new Project(name, description);
            session.persist(project);
            projectId = project.getId();
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
    public int create(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int projectId = 0;

        try {
            transaction = session.beginTransaction();
            session.persist(project);
            projectId = project.getId();
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
    public boolean updateCore(Project project) {
        if (project == null) {
            System.out.println("No project selected");
            return false;
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean updated = false;

        try {
            transaction = session.beginTransaction();
            session.merge(project);
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
    public boolean updateByNewModel(Project updatedProject) {
        return this.updateCore(updatedProject);
    }

    @Override
    public boolean updateByNewData(int projectId, Object... args) {
        if (args.length < 2) {
            System.out.println("Insufficient arguments provided");
            return false;
        }

        String name = (String) args[0];
        String description = (String) args[1];

        Project updatedProject = new Project(name, description);
        updatedProject.setId(projectId);
        return this.updateCore(updatedProject);
    }

//    public List<Sprint> getSprintsById(int id) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = null;
//        List<Sprint> sprints = null;
//
//        try {
//            transaction = session.beginTransaction();
//            Project project = session.get(Project.class, id);
//            sprints = project.getSprints();
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//        return sprints;
//    }

    public List<Object[]> getByIdSprint(int id) throws ClassNotFoundException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Object[]> projects = null;

        try {
            transaction = session.beginTransaction();
            Query<Object[]> query = session.createQuery("FROM Project p LEFT JOIN p.sprints s WHERE s.project_id = :id", Object[].class);
            query.setParameter("id", id);

            projects = query.list();
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







    @Override
    public boolean update() {
        return this.updateCore(this.project);
    }

    @Override
    public boolean delete(int id) throws ClassNotFoundException {
        return controller.delete(id);
    }
}
