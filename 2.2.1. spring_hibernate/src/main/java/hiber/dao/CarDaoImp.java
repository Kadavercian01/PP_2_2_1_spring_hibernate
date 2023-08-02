package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.openSession().createQuery("from Car", Car.class);
        return query.getResultList();
    }
}
