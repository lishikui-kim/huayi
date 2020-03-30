package com.example.mimile.service;

import com.example.mimile.beans.User;
import com.example.mimile.beans.UserLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public void save(User u)throws Exception;
    public Page<User> findAll(String kw, Pageable pageable);
    public User findById(Integer uid);
    public void delete(User u);
    public void deleteById(Integer uid);
    public void deletes(List<User> users);
    public User checkUser(UserLogin user);

}
