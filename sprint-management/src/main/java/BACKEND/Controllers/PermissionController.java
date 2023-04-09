package BACKEND.Controllers;

import BACKEND.Models.Permission;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class PermissionController implements ControllerInterface {

    private final SessionFactory sessionFactory;
    private Permission permission;

    /**
     * Constructor for PermissionController.
     * 
     * @param sessionFactory The Hibernate SessionFactory used to create sessions.
     */
    public PermissionController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    /**
     * Gets the currently selected Permission.
     * 
     * @return The currently selected Permission.
     */
    public Permission getPermission() {
        return permission;
    }

    /**
     * Sets the currently selected Permission.
     * 
     * @param permission The Permission to set as the currently selected Permission.
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    /**
     * Retrieves all Permissions from the database.
     * 
     * @return A List of all Permissions in the database.
     */
    public List<Permission> getAllPermissions() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Permission> permissions = null;

        try {
            transaction = session.beginTransaction();
            permissions = session.createQuery("from Permission").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return permissions;
    }

    /**
     * Retrieves a Permission by its ID.
     * 
     * @param id The ID of the Permission to retrieve.
     * @return The Permission with the specified ID, or null if no such Permission
     *         exists.
     */
    public Permission getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Permission permission = null;

        try {
            transaction = session.beginTransaction();
            permission = session.get(Permission.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return permission;
    }

    /**
     * Creates a new permission with the specified name and description.
     *
     * @param name        The name of the permission.
     * @param description The description of the permission.
     * @return The ID of the newly created permission.
     */
    public int create(String name, String description) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int permissionId = 0;

        try {
            transaction = session.beginTransaction();
            Permission permission = new Permission(name, description);
            permissionId = (int) session.save(permission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return permissionId;
    }

    /**
     * Creates a new permission with the specified name and description.
     *
     * @param permission The permission to create.
     * @return The ID of the newly created permission.
     */
    public int create(Permission permission) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int permissionId = 0;

        try {
            transaction = session.beginTransaction();
            permissionId = (int) session.save(permission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return permissionId;
    }

    @Override
    public boolean updateCore(Object permission) {
        if (permission instanceof Permission) {
            System.out.println("obj is not an instance of Permission");
            return false;
        }

        if (permission == null) {
            System.out.println("No project selected");
            return false;
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean updated = false;

        try {
            transaction = session.beginTransaction();
            session.update(permission);
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

    public boolean updateByNewModel(Permission updatedPermission) {
        return this.updateCore(updatedPermission);
    }

    public boolean updateByNewData(int permissionId, String newPermissionName, String newDescription) {
        Permission updatedPermission = new Permission(newPermissionName, newDescription);
        updatedPermission.setId(permissionId);
        return this.updateCore(updatedPermission);
    }

    public boolean update() {
        return this.updateCore(this.permission);
    }

    /**
     * Deletes a permission by its ID.
     *
     * @param id The ID of the permission to delete.
     * @return true if the permission was deleted successfully, false otherwise.
     */
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            Permission permission = session.get(Permission.class, id);
            if (permission != null) {
                session.delete(permission);
                transaction.commit();
                deleted = true;
            } else {
                System.out.println("Permission with id " + id + " not found");
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
     * Deletes a permission.
     *
     * @param permission The permission to delete.
     * @return true if the permission was deleted successfully, false otherwise.
     */
    public boolean delete(Permission permission) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            session.delete(permission);
            transaction.commit();
            deleted = true;
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
     * Deletes the currently selected permission.
     * 
     * @return true if the permission was successfully deleted, false otherwise
     */
    public boolean delete() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean deleted = false;

        try {
            transaction = session.beginTransaction();
            Permission permission = session.get(Permission.class, this.permission.getId());
            if (permission != null) {
                session.delete(permission);
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