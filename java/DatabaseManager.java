import javax.persistence.*;
import java.util.List;

public class DatabaseManager {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public DatabaseManager() {
        factory = Persistence.createEntityManagerFactory("default");
        manager = factory.createEntityManager();
    }

    public void add(Point point) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(point);
        transaction.commit();
    }

    public List<Point> getAll() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        TypedQuery<Point> query = manager.createQuery("select p from Point p", Point.class);
        List<Point> pointList = query.getResultList();
        transaction.commit();
        return pointList;
    }

    public void clear() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.createQuery("delete from Point").executeUpdate();
        transaction.commit();
    }
}
