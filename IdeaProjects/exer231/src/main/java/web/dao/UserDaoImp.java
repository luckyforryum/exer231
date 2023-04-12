package web.dao;

import web.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> allEmployees = entityManager.createQuery("from User", User.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void update(Long id, User updatedUser) {
        User user = getUser(id);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
    }

    @Override
    public void deleteUser(Long id) {
        Query query = entityManager.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
