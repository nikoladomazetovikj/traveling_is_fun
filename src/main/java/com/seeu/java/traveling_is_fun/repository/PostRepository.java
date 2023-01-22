package com.seeu.java.traveling_is_fun.repository;

import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    void likePost(Long postId, Long userId);

    void commentOnPost(Long postId, Long userId, String text);
    void createPost(Long userId,String title, String content);
    void editPost(Long postId, String title, String content);
    int getNumberOfLikes(Long postId);

    int getNumberOfComments(Long postId);
    List<User> getLikedUsers(Long postId);

    List<User> getCommentedUsers(Long postId);

}
