package org.kataew.project.controllers;


import org.kataew.project.entities.MaterialEntity;
import org.kataew.project.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173/")
@Controller
public class MaterialController {

    private final MaterialRepository materialRepository;

    public MaterialController(@Autowired MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @PostMapping("/addMaterial")
    public ResponseEntity<String> addMaterial(@RequestBody MaterialEntity materialEntity) {
        materialRepository.save(materialEntity);
        return new ResponseEntity<>("Material addd", HttpStatus.OK);
    }

    @GetMapping("/getAllMaterials")
    public ResponseEntity<?> getAllMaterials() {
        List<MaterialEntity> materialEntities = materialRepository.findAll();
        return new ResponseEntity<>(materialEntities, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMaterial/{materialId}")
    public ResponseEntity<?> deleteMaterial(@PathVariable Long materialId) {
        if (materialRepository.existsById(materialId)) {
            materialRepository.deleteById(materialId);
        } else {
            return new ResponseEntity<>("Material is undefined", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Material deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateMaterial")
    public ResponseEntity<?> updateMaterial(@RequestBody MaterialEntity materialEntity) {
        if (materialRepository.existsById(materialEntity.getIdMaterial())) {
            materialRepository.save(materialEntity);
        } else {
            return new ResponseEntity<>("Material is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(materialEntity, HttpStatus.OK);
    }
}
