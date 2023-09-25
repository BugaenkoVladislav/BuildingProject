package org.kataew.project.controllers;

import org.kataew.project.entities.MaterialEntity;
import org.kataew.project.entities.WorkStatusEntity;
import org.kataew.project.repositories.MaterialRepository;
import org.kataew.project.repositories.WorkStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173/")
@Controller
public class WorkStatusController {

    private final WorkStatusRepository workStatusRepository;

    public WorkStatusController(@Autowired WorkStatusRepository workStatusRepository) {
        this.workStatusRepository = workStatusRepository;
    }

    @PostMapping("/createWorkStatus")
    public ResponseEntity<String> createWorkStatus(@RequestBody WorkStatusEntity workStatusEntity) {
        workStatusRepository.save(workStatusEntity);
        return new ResponseEntity<>("Work status created", HttpStatus.OK);
    }

    @GetMapping("/getAllWorkStatuses")
    public ResponseEntity<?> getAllWorkStatuses() {
        List<WorkStatusEntity> workStatusEntities = workStatusRepository.findAll();
        return new ResponseEntity<>(workStatusEntities, HttpStatus.OK);
    }

    @DeleteMapping("/deleteWorkStatus/{workStatusId}")
    public ResponseEntity<?> deleteWorkStatus(@PathVariable Long workStatusId) {
        if (workStatusRepository.existsById(workStatusId)) {
            workStatusRepository.deleteById(workStatusId);
        } else {
            return new ResponseEntity<>("Work status is undefined", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Work status deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateWorkStatus")
    public ResponseEntity<?> updateWorkStatus(@RequestBody WorkStatusEntity workStatusEntity) {
        if (workStatusRepository.existsById(workStatusEntity.getIdWorkStatus())) {
            workStatusRepository.save(workStatusEntity);
        } else {
            return new ResponseEntity<>("Work status is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(workStatusEntity, HttpStatus.OK);
    }
}
