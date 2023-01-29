package com.seeu.java.traveling_is_fun.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    void PostConstructor(){
        User user= new User("Andrea","Makedonija","Bilbilovska","ab@email.com","Ani","pass",true,false);
        Post post= new Post("Title","Content",user,"LAKES");
        assertEquals("Title",post.getTitle());
        assertEquals("Content",post.getContent());
        assertEquals(user,post.getAuthor());
        assertEquals("LAKES",post.getCategory());
    }

    @Test
    void someCommentMethod(){
        Post post= new Post();
        post.setContent("Content");
        assertEquals("Content", post.getContent());
    }
}