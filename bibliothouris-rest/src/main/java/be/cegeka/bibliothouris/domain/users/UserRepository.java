package be.cegeka.bibliothouris.domain.users;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Named
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("Select u from User u", User.class).getResultList();
    }

    public User addUser(User user){
        entityManager.persist(user);
        return user;
    }

    public User getUserByFirstName(String firstname) {
        return entityManager.createQuery("select u from User u where u.firstname like :firstname", User.class)
                .setParameter("firstname", firstname)
                .getSingleResult();
    }
}
