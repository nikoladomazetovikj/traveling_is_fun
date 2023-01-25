package com.seeu.java.traveling_is_fun.repository;

import com.seeu.java.traveling_is_fun.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
