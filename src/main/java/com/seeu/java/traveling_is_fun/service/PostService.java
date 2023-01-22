package com.seeu.java.traveling_is_fun.service;

import com.seeu.java.traveling_is_fun.pojo.Category;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

        public PostService(PostRepository postRepository) {
            this.postRepository = postRepository;
         }

    public void createPost(Long id, String title, String content, User author, Category category) {
        Post post= new Post(id,title,content,author,category);
        postRepository.save(post);

    }

}
