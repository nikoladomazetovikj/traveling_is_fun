package com.seeu.java.traveling_is_fun.controller;

import com.seeu.java.traveling_is_fun.pojo.Comment;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PostController {
    private PostService postService;

    @PutMapping("/posts/{id}/like")
    public void likePost(@PathVariable Long id, @RequestBody User user) {
        postService.likePost(id, user.getId());
    }

    @PutMapping("/posts/{id}/comment")
    public void commentOnPost(@PathVariable Long id, @RequestBody Comment comment) {
        postService.commentOnPost(id, comment.getUser().getId(), comment.getText());
    }

    @PostMapping("/posts")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post.getAuthor().getId(), post.getTitle(), post.getContent());
    }

    @PutMapping("/posts/{id}")
    public void editPost(@PathVariable Long id, @RequestBody Post post) {
        postService.editPost(id, post.getTitle(), post.getContent());
    }
    @GetMapping("/posts/{id}/likes")
    public int getNumberOfLikes(@PathVariable Long id) {
        return postService.getNumberOfLikes(id);
    }

    @GetMapping("/posts/{id}/comments")
    public int getNumberOfComments(@PathVariable Long id) {
        return postService.getNumberOfComments(id);
    }

    @GetMapping("/{id}/likedUsers")
    public List<User> getLikedUsers(@PathVariable Long id) {
        return postService.getLikedUsers(id);
    }

    @GetMapping("/{id}/commentedUsers")
    public List<User> getCommentedUsers(@PathVariable Long id) {
        return postService.getCommentedUsers(id);
    }

}
