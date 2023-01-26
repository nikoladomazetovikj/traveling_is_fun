package com.seeu.java.traveling_is_fun.service;

import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
    public void createUser(String name,String country, String surname, String email,String userName, String password,Boolean isAdmin,Boolean isBlogger){
        User user= new User(name,country,surname,email,userName,password,isAdmin,isBlogger);
        userRepository.save(user);
    }



    public Boolean deleteUser(Long adminId,Long userId) {
        User admin = getUserById(adminId);
        User deleted = getUserById(userId);
        if (admin.isAdmin()) {
            userRepository.delete(deleted);
            return true;
        }
        return false;
    }
    public void save(User user) {
        userRepository.save(user);
    }

}