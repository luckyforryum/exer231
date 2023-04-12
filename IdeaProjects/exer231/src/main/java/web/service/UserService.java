package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(Long id);
    public void update(Long id,User user);

    public void deleteUser(Long id);
}
