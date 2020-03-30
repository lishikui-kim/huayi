package com.example.mimile.dao;

import com.example.mimile.beans.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.account like ?1 or u.name like ?1 or u.mobile like ?1 or u.email like ?1")
    public Page<User> findByKeyword(String kw, Pageable pageable);
    @Query("update User u set u.password=?1 where u.uid=?2")
    public void modifyPassword(String pwd, Integer uid);
    public Optional<User> findByAccount(String account);
}
