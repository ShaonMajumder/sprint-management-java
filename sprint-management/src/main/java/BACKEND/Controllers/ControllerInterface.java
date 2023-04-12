package BACKEND.Controllers;

import BACKEND.Models.User;
import org.hibernate.SessionFactory;
import java.util.List;

public interface ControllerInterface <T> {
    final SessionFactory sessionFactory = null;    
    T getModel();
    void setModel(T entity);
    List <T> getAllModels();
    T getById(int id) throws ClassNotFoundException;
    int create(String... args);
    int create(T entity);
    boolean updateCore(T entity);
    boolean updateByNewModel(T entity);
    boolean updateByNewData(int userId, String... args);
    boolean update();
}