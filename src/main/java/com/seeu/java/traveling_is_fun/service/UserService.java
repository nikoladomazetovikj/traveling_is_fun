package com.seeu.java.traveling_is_fun.service;

import com.seeu.java.traveling_is_fun.exception.AlreadyDeletedException;
import com.seeu.java.traveling_is_fun.exception.AlreadyExistsException;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserById(Long id) {
          return userRepository.findById(id).get();
    }

    //
//    public void deleteUser(Long id) {
//        User user= userRepository.findById(id.intValue()).get();
//        if(userRepository.existsById(id.intValue())) { //ova
//            userRepository.deleteById(id.intValue());
//        }
//        else throw new AlreadyDeletedException("This user has been already deleted");
//    }
    public void save(User user) {
        userRepository.save(user);
    }

}
