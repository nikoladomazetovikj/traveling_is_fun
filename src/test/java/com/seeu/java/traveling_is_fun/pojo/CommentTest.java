package com.seeu.java.traveling_is_fun.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    @Test
    void CommentConstructor(){
        User user= new User("Andrea","Makedonija","Bilbilovska","ab@email.com","Ani","pass",true,false);
        Post post= new Post("Title","Content",user,"LAKES");
        Comment comment=new Comment("text",post,user);
        assertEquals("text",comment.getText());
        assertEquals(user,comment.getUser());
        assertEquals(post,comment.getPost());
    }
   @Test
    void someCommentMethod(){
        Comment comment= new Comment();
        comment.setText("Tekst");
        assertNotEquals("Tekst1",comment.getText());
   }

}