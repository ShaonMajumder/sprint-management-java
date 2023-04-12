package BACKEND.Controllers;

import BACKEND.Models.Sprint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class SprintController {

    private final SessionFactory sessionFactory;
    private Sprint sprint;

    public SprintController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Sprint getModel() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public List<Sprint> getAllModels() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Sprint> sprints = null;

        try {
            transaction = session.beginTransaction();
            sprints = session.createQuery("from Sprint").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return sprints;
    }

    public Sprint getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Sprint sprint = null;

        try {
            transaction = session.beginTransaction();
            sprint = session.get(Sprint.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return sprint;
    }

    public int create(String name, String description, Date startDate, Date endDate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int sprintId = 0;

        try {
            transaction = session.beginTransaction();
            Sprint sprint = new Sprint(name, description, startDate, endDate);
            sprintId = (int) session.save(sprint);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return sprintId;
    }

    public int create(Sprint sprint) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int sprintId = 0;

        try {
            transaction = session.beginTransaction();
            sprintId = (int) session.save(sprint);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return sprintId;
    }

//    @Override
    public boolean updateCore(Object sprint) {
        if (sprint instanceof Sprint) {
            System.out.println("obj is not an instance of Sprint");
            return false;
        }

        if (sprint == null) {
            System.out.println("No sprint selected");
            return false;
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean updated = false;

        try {
            transaction = session.beginTransaction();
            session.update(sprint);
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

    public boolean updateByNewModel(Sprint updatedSprint) {
        return this.updateCore(updatedSprint);
    }

    public boolean updateByNewData(int sprintId, String newName, String newDescription, Date newStartDate, Date newEndDate) {
        Sprint updatedSprint = new Sprint(newName, newDescription, newStartDate, newEndDate);
        updatedSprint.setId(sprintId);
        return this.updateCore(updatedSprint);
    }

    public boolean update() {
        return this.updateCore(this.sprint);
    }

}
