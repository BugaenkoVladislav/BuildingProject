package org.kataew.project.controllers;

import org.kataew.project.entities.ScopeOfWorkEntity;
import org.kataew.project.repositories.ScopeOfWorkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ScopeOfWorkController {
    ScopeOfWorkRepository scopeOfWorkEntityRepository;
    ScopeOfWorkController(ScopeOfWorkRepository scopeOfWorkEntityRepository){
        this.scopeOfWorkEntityRepository = scopeOfWorkEntityRepository;
    }
    @PostMapping("/createScopeOfWork")
    public ResponseEntity<String> createScopeOfWork(@RequestBody ScopeOfWorkEntity scopeOfWorkEntity) {
        scopeOfWorkEntityRepository.save(scopeOfWorkEntity);
        return new ResponseEntity<>("Scope of work created", HttpStatus.OK);
    }

    @GetMapping("/getAllScopesOfWork")
    public ResponseEntity<?> getAllScopesOfWork() {
        List<ScopeOfWorkEntity> scopesOfWork = scopeOfWorkEntityRepository.findAll();
        return new ResponseEntity<>(scopesOfWork, HttpStatus.OK);
    }

    @DeleteMapping("/deleteScopeOfWork/{scopeOfWorkId}")
    public ResponseEntity<?> deleteScopeOfWork(@PathVariable Long scopeOfWorkId) {
        if (scopeOfWorkEntityRepository.existsById(scopeOfWorkId)) {
            scopeOfWorkEntityRepository.deleteById(scopeOfWorkId);
        } else {
            return new ResponseEntity<>("Scope of work is undefined", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Scope of work deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateScopeOfWork")
    public ResponseEntity<?> updateScopeOfWork(@RequestBody ScopeOfWorkEntity scopeOfWorkEntity) {
        if (scopeOfWorkEntityRepository.existsById(scopeOfWorkEntity.getIdScopeOfWork())) {
            scopeOfWorkEntityRepository.save(scopeOfWorkEntity);
        } else {
            return new ResponseEntity<>("Scope of work is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(scopeOfWorkEntity, HttpStatus.OK);
    }
}
