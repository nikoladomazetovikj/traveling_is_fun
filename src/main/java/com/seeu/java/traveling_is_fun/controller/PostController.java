package com.seeu.java.traveling_is_fun.controller;

import com.seeu.java.traveling_is_fun.controller.request.PostRequest;
import com.seeu.java.traveling_is_fun.pojo.Category;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private  final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/posts/allPosts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/posts/create")
    public void createPost(@RequestBody PostRequest post) {
        postService.createPost(post.title, post.content, post.userId, post.categoryId);

    }
    @PutMapping("/posts/edit/{id}")
    public void editPost(@PathVariable Long id,@RequestParam String title,@RequestParam String content,@RequestParam Category category){
        postService.editPost(id,title,content,category);
    }

    @DeleteMapping("/posts/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
    @PutMapping("/posts/like/{id}")
    public void likePost(@PathVariable Long id, @RequestBody User author){

    }


}
