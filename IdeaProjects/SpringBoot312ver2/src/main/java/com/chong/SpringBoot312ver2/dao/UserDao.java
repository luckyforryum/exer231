package com.chong.SpringBoot312ver2.dao;





import com.chong.SpringBoot312ver2.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(Long id);

    public void deleteUser(Long id);



}
