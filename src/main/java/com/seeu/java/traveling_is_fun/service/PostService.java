package com.seeu.java.traveling_is_fun.service;

import com.seeu.java.traveling_is_fun.pojo.Category;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Post getPostById(Long id){
            return postRepository.findById(id);
    }



    public void createPost(Long id, String title, String content, User author, Category category) {
        Post post = new Post(id, title, content, author, category);
        postRepository.save(post);

    }
//    public Post editPost(Long id,String title, String content, User author, Category category ){
//        Post post= postRepository.findById(id);
//        if(post != null){
//            post.setTitle(title);
//            post.setContent(content);
//            post.setCategory(category);
//            return postRepository.save(post);
//        }
//          return null;
//    }



}
