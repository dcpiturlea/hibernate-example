package ro.bogdan.hibernatemappingdemo.onetomany;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Post post) {
        entityManager.persist(post);
    }
}
