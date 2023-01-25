package com.seeu.java.traveling_is_fun.service;

import com.seeu.java.traveling_is_fun.pojo.Category;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category getCategoryById(Long id) {

        Optional<Category> category= categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }
        return  null;
    }
}
