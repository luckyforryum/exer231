package com.chong.SpringBoot312ver2.service;


import com.chong.SpringBoot312ver2.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(Long id);

    public void deleteUser(Long id);
}
