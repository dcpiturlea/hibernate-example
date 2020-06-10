package ro.bogdan.hibernatemappingdemo.onetoone;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        Query query = entityManager.createNativeQuery("select * from user", User.class);
        return query.getResultList();
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user.getAddress());
        entityManager.persist(user);
    }
}
