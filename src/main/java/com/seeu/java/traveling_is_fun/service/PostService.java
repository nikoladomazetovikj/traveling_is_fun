package com.seeu.java.traveling_is_fun.service;

import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    private PostRepository postRepository;

    public void likePost(Long postId, Long userId) {
        postRepository.likePost(postId, userId);
    }

    public void commentOnPost(Long postId, Long userId, String text) {
        postRepository.commentOnPost(postId, userId, text);
    }
    public void createPost(Long userId,String title, String content) {
        postRepository.createPost(userId,title, content);
    }
    public void editPost(Long postId, String title, String content) {
        postRepository.editPost(postId, title, content);
    }
    public int getNumberOfLikes(Long postId) {
        return postRepository.getNumberOfLikes(postId);
    }

    public int getNumberOfComments(Long postId) {
        return postRepository.getNumberOfComments(postId);
    }
    public List<User> getLikedUsers(Long postId) {
        return postRepository.getLikedUsers(postId);
    }

    public List<User> getCommentedUsers(Long postId) {
        return postRepository.getCommentedUsers(postId);
    }
}
