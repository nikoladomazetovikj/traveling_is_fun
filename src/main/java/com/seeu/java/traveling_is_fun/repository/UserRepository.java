package com.seeu.java.traveling_is_fun.repository;

import com.seeu.java.traveling_is_fun.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}