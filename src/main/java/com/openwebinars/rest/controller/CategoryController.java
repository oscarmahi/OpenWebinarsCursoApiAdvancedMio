package com.openwebinars.rest.controller;

import com.openwebinars.rest.model.Category;
import com.openwebinars.rest.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> findAllCategory(){

        List<Category> resul = categoryService.findAllCategoryService();

        if (resul == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.ok(resul);
        }

    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable Long id){
        Category resul = categoryService.findByIdService(id).orElse(null);
        if (resul == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(resul);
        }
    }

    @PostMapping("/category")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category resul = categoryService.saveService(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(resul);
    }

}
