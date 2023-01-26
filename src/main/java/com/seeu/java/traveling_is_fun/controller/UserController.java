package com.seeu.java.traveling_is_fun.controller;

import com.seeu.java.traveling_is_fun.controller.request.UserRequest;
import com.seeu.java.traveling_is_fun.pojo.Comment;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.service.CommentService;
import com.seeu.java.traveling_is_fun.service.PostService;
import com.seeu.java.traveling_is_fun.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final CommentService commentService;

    private final PostService postService;

    public UserController(UserService userService, CommentService commentService, PostService postService) {
        this.userService = userService;
        this.commentService = commentService;
        this.postService = postService;
    }
    @GetMapping
    public List<User> findAll() {
        return userService.findAllUsers();
    }
    @PostMapping("/create")
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest.name,userRequest.country,userRequest.surname,userRequest.email,userRequest.userName,userRequest.password,userRequest.isAdmin,userRequest.isBlogger);
    }

    @PutMapping("/{userId}/like/{postId}")
    public void likePost(@PathVariable Long userId, @PathVariable Long postId){
        User user = userService.getUserById(userId);
        Post post= postService.getPostById(postId);
        List<Post> likedPosts= user.getLikedPosts();
        likedPosts.add(post);
        userService.save(user);
    }
    @PostMapping("/{userId}/comment/{postId}")
    public void comment(@PathVariable Long userId,@PathVariable Long postId, @RequestParam String comment) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);
        Comment comment1 = new Comment(comment,post,user);
        commentService.save(comment1);
    }
    @DeleteMapping("/{userAdminId}/delete/{userDeletedId}")
    public ResponseEntity<String> delete(@PathVariable Long userAdminId,@PathVariable Long userDeletedId) {
        if(userService.deleteUser(userAdminId,userDeletedId)) {
            return ResponseEntity.ok().body("User was successfully deleted");
        }
        return ResponseEntity.badRequest().body("Deleting user is not admin");
    }
}
