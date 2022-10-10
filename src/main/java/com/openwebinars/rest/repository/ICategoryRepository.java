package com.openwebinars.rest.repository;

import com.openwebinars.rest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
