package com.seeu.java.traveling_is_fun.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void UserConstructor(){
        User user= new User("Nikola","Makedonija","Domazetovic","nd@email.com","nd","pass",true,false);

        assertEquals("Nikola",user.getName());
        assertEquals("Makedonija",user.getCountry());
        assertEquals("Domazetovic",user.getSurname());
        assertNotEquals("ab@email.com",user.getEmail());
        assertEquals("nd",user.getUserName());
        assertNotEquals("pas",user.getPassword());

    }

    @Test
    void someUserMethod(){
        User user = new User();
        user.isAdmin();
        assertNotEquals("false", user.isAdmin());
    }


}