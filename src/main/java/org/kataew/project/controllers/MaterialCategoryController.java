package org.kataew.project.controllers;

import org.kataew.project.entities.MaterialCategoryEntity;
import org.kataew.project.repositories.MaterialCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173/")
@Controller
public class MaterialCategoryController {

    private final MaterialCategoryRepository materialCategoryRepository;

    public MaterialCategoryController(@Autowired MaterialCategoryRepository materialCategoryRepository) {
        this.materialCategoryRepository = materialCategoryRepository;
    }

    @PostMapping("/addMaterialCategory")
    public ResponseEntity<String> addMaterialCategory(@RequestBody MaterialCategoryEntity materialCategoryEntity) {
        materialCategoryRepository.save(materialCategoryEntity);
        return new ResponseEntity<>("Material category addd", HttpStatus.OK);
    }

    @GetMapping("/getAllMaterialCategories")
    public ResponseEntity<?> getAllMaterialCategories() {
        List<MaterialCategoryEntity> materialCategoryEntities = materialCategoryRepository.findAll();
        return new ResponseEntity<>(materialCategoryEntities, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMaterialCategory/{materialCategoryId}")
    public ResponseEntity<?> deleteMaterialCategory(@PathVariable Long materialCategoryId) {
        if (materialCategoryRepository.existsById(materialCategoryId)) {
            materialCategoryRepository.deleteById(materialCategoryId);
        } else {
            return new ResponseEntity<>("Material category is undefined", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Material category deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateMaterialCategory")
    public ResponseEntity<?> updateMaterialCategory(@RequestBody MaterialCategoryEntity materialCategoryEntity) {
        if (materialCategoryRepository.existsById(materialCategoryEntity.getIdMaterialCategory())) {
            materialCategoryRepository.save(materialCategoryEntity);
        } else {
            return new ResponseEntity<>("Material category is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(materialCategoryEntity, HttpStatus.OK);
    }
}
