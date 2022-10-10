package com.openwebinars.rest.service;

import com.openwebinars.rest.model.Category;
import com.openwebinars.rest.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository iCategoryRepository;

    public Category saveService(Category newC) {
        return iCategoryRepository.save(newC);
    }

    public Optional<Category> findByIdService(Long id) {
        return iCategoryRepository.findById(id);
    }

    public List<Category> findAllCategoryService(){
        return iCategoryRepository.findAll();
    }

}
