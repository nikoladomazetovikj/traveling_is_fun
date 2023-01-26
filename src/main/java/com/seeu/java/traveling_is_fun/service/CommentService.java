package com.seeu.java.traveling_is_fun.service;

import com.seeu.java.traveling_is_fun.pojo.Comment;
import com.seeu.java.traveling_is_fun.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void save(Comment c) {
        commentRepository.save(c);
    }
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}