package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(Long id);
    public void update(Long id,User user);

    public void deleteUser(Long id);



}
