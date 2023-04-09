package BACKEND.Controllers;

import org.hibernate.SessionFactory;

public interface ControllerInterface {
    final SessionFactory sessionFactory = null;
    boolean updateCore(Object obj);
}