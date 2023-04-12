package BACKEND.Controllers;

import BACKEND.Models.User;
import org.hibernate.SessionFactory;
import java.util.List;

public interface ControllerInterface <T> {
    final SessionFactory sessionFactory = null;
    
    Object getModel();
    void setModel(Object obj);
    List <T> getAllModels();
    boolean updateCore(Object obj);
}