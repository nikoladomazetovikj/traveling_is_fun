package com.seeu.java.traveling_is_fun.service;

import com.seeu.java.traveling_is_fun.exception.NotFoundException;
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
    private final UserService userService;
    private final CategoryService categoryService;


    public PostService(PostRepository postRepository, UserService userService, CategoryService categoryService) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {

        Optional<Post> post= postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }
        return  null;
    }


    public void createPost(String title, String content, Long userId, Long categoryId) {
        User author = userService.getUserById(userId);
        Category category=categoryService.getCategoryById(categoryId);
        Post post = new Post( title, content, author, category);
        postRepository.save(post);

    }
    public void editPost(Long id,String title,String content, Category category) {
        Optional<Post> postWrapper= postRepository.findById(id);
      if(postWrapper.isPresent()) {
          Post post =postWrapper.get();
          post.setTitle(title);
          post.setContent(content);
          post.setCategory(category);
          postRepository.save(post);
      }
      else throw  new NotFoundException("The post doesn't exists!");
    }


    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }



//    public void commentOnPost(Long id, User author){
//        Post post  =postRepository.findById(id.intValue()).get();
//        if(postRepository.existsById(id.intValue())){
//
//        }
//    }
//    public List<User> likedPost(Long id){
//        List<User> users= new ArrayList<>();
//        return users;
//
//    }
//    public List<User> commentedOnPost(Long id){
//        List<User> users = new ArrayList<>();
//        Post post= postRepository.findById(id.intValue()).get();
//        if(postRepository.existsById(id.intValue()) )
//        {}
//        return users;
//    }





}
