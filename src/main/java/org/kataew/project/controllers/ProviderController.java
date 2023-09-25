package org.kataew.project.controllers;


import org.kataew.project.entities.ProviderEntity;
import org.kataew.project.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173/")
@Controller
public class ProviderController {

    private final ProviderRepository providerRepository;

    public ProviderController(@Autowired ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @PostMapping("/createProvider")
    public ResponseEntity<String> createProvider(@RequestBody ProviderEntity providerEntity) {
        providerRepository.save(providerEntity);
        return new ResponseEntity<>("Provider created", HttpStatus.OK);
    }

    @GetMapping("/getAllProviders")
    public ResponseEntity<?> getAllProviders() {
        List<ProviderEntity> providerEntities = providerRepository.findAll();
        return new ResponseEntity<>(providerEntities, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProvider/{providerId}")
    public ResponseEntity<?> deleteProvider(@PathVariable Long providerId) {
        providerRepository.deleteById(providerId);
        return new ResponseEntity<>("Provider deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateProvider")
    public ResponseEntity<?> updateProvider(@RequestBody ProviderEntity providerEntity) {
        if (providerRepository.existsById(providerEntity.getIdProvider())) {
            providerRepository.save(providerEntity);
        } else {
            return new ResponseEntity<>("Provider is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(providerEntity, HttpStatus.OK);
    }
}
