package BACKEND.Controllers;

import BACKEND.Models.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class TaskController {

    private final SessionFactory sessionFactory;
    private Task task;

    /**
     * Constructor for TaskController.
     * 
     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
     */
    public TaskController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Gets the currently selected Task.
     * 
     * @return The currently selected Task.
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets the currently selected Task.
     * 
     * @param task The Task to set as the currently selected Task.
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * Retrieves all Tasks from the database.
     * 
     * @return A List of all Tasks in the database.
     */
    public List<Task> getAllTasks() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Task> tasks = null;

        try {
            transaction = session.beginTransaction();
            tasks = session.createQuery("from Task").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return tasks;
    }

    /**
     * Retrieves a Task by its ID.
     * 
     * @param id The ID of the Task to retrieve.
     * @return The Task with the specified ID, or null if no such Task exists.
     */
    public Task getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Task task = null;

        try {
            transaction = session.beginTransaction();
            task = session.get(Task.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return task;
    }

    /**
     * Creates a new task with the specified name and description.
     *
     * @param name        The name of the task.
     * @param description The description of the task.
     * @return The ID of the newly created task.
     */
    public int create(String name, String description, int points, double duration) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int taskId = 0;

        try {
            transaction = session.beginTransaction();
            Task task = new Task(name, description, points, duration);

            taskId = (int) session.save(task);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return taskId;
    }

    /**
     * Creates a new task with the specified name and description.
     *
     * @param name        The name of the task.
     * @param description The description of the task.
     * @return The ID of the newly created task.
     */
    public int create(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int taskId = 0;

        try {
            transaction = session.beginTransaction();
            taskId = (int) session.save(task);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return taskId;
    }

//    @Override
    public boolean updateCore(Object task) {
        if (task instanceof Task) {
            System.out.println("obj is not an instance of Task");
            return false;
        }

        if (task == null) {
            System.out.println("No task selected");
            return false;
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean updated = false;

        try {
            transaction = session.beginTransaction();
            session.update(task);
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

    public boolean updateByNewModel(Task updatedTask) {
        return this.updateCore(updatedTask);
    }

    public boolean updateByNewData(int taskId, String newName, String newDescription, int newPoints, double newDuration) {
        Task updatedTask = new Task( newName,  newDescription, newPoints, newDuration) ;
        updatedTask.setId(taskId);
        return this.updateCore(updatedTask);
    }

    public boolean update() {
        return this.updateCore(this.task);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id The ID of the task to delete.
     * @return true if the task was deleted successfully, false otherwise.
     */
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            Task task = session.get(Task.class, id);
            if (task != null) {
                session.delete(task);
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
     * Deletes a task.
     *
     * @param paramTask The task to delete.
     * @return true if the task was deleted successfully, false otherwise.
     */
    public boolean delete(Task paramTask) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            Task task = session.get(Task.class, paramTask.getId());
            if (task != null) {
                session.delete(task);
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
     * Deletes the currently selected task.
     * 
     * @return true if the task was successfully deleted, false otherwise
     */
    public boolean delete() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            Task task = session.get(Task.class, this.task.getId());
            if (task != null) {
                session.delete(task);
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
