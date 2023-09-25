package org.kataew.project.controllers;

import org.kataew.project.entities.AvailableMaterialEntity;
import org.kataew.project.entities.ProviderEntity;
import org.kataew.project.repositories.AvailableMaterialRepository;
import org.kataew.project.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173/")
@Controller
public class AvailableMaterialController {

    private final AvailableMaterialRepository availableMaterialRepository;

    public AvailableMaterialController(@Autowired AvailableMaterialRepository availableMaterialRepository) {
        this.availableMaterialRepository = availableMaterialRepository;
    }

    @PostMapping("/createAvailableMaterial")
    public ResponseEntity<String> createAvailableMaterial(@RequestBody AvailableMaterialEntity availableMaterialEntity) {
        availableMaterialRepository.save(availableMaterialEntity);
        return new ResponseEntity<>("Available material created", HttpStatus.OK);
    }

    @GetMapping("/getAllAvailableMaterials/{projectId}")
    public ResponseEntity<?> getAllAvailableMaterials(@PathVariable Long projectId) {
        List<AvailableMaterialEntity> availableMaterialEntities = availableMaterialRepository.findAvailableMaterialEntitiesByIdProject(projectId);
        return new ResponseEntity<>(availableMaterialEntities, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAvailableMaterial/{availableMaterialId}")
    public ResponseEntity<?> deleteAvailableMaterial(@PathVariable Long availableMaterialId) {
        if (availableMaterialRepository.existsById(availableMaterialId)) {
            availableMaterialRepository.deleteById(availableMaterialId);
        } else {
            return new ResponseEntity<>("Available material is undefined", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Available material deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateAvailableMaterial")
    public ResponseEntity<?> updateAvailableMaterial(@RequestBody AvailableMaterialEntity availableMaterialEntity) {
        if (availableMaterialRepository.existsById(availableMaterialEntity.getIdAvailableMaterial())) {
            availableMaterialRepository.save(availableMaterialEntity);
        } else {
            return new ResponseEntity<>("Available material is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(availableMaterialEntity, HttpStatus.OK);
    }
}
