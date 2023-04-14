package backend.seeders;

import backend.controllers.PermissionController;
import backend.models.Permission;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PermissionSeeder implements SeederInterface {

    private final SessionFactory sessionFactory;

    public PermissionSeeder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void seed() {
        PermissionController permissionController = new PermissionController(sessionFactory);
        List<Permission> permissions = new ArrayList<>();
        permissions.add(new Permission("create_user", "Allows the user to create new user accounts."));
        permissions.add(new Permission("delete_user", "Allows the user to delete user accounts."));
        permissions.add(new Permission("view_user", "Allows the user to view user accounts."));

        for (Permission permission : permissions) {
            permissionController.create(permission);
        }
    }

    public void truncate() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Permission");
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
