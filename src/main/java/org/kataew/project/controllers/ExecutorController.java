package org.kataew.project.controllers;

import org.apache.catalina.Executor;
import org.kataew.project.entities.ExecutorEntity;
import org.kataew.project.entities.ScopeOfWorkEntity;
import org.kataew.project.repositories.ExecutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:5173/")
@RestController
public class ExecutorController {
    ExecutorRepository executorEntityRepository;
    ExecutorController(ExecutorRepository executorEntityRepository){
        this.executorEntityRepository = executorEntityRepository;
    }

    @GetMapping("/getAllExecutors")
    public Iterable<ExecutorEntity> getAllExecutors(){
        return executorEntityRepository.findAll();
    }
    @PostMapping("/addNewExecutor")
    public ResponseEntity<String> addExecutor(@RequestBody ExecutorEntity executorEntity){
        executorEntityRepository.save(executorEntity);
        return new ResponseEntity<>("executor added", HttpStatus.OK);
    }
    @DeleteMapping("/deleteExecutor/{id}")
    public ResponseEntity<String> deleteExecutroe(@PathVariable long id){
        if(executorEntityRepository.findById(id).isEmpty()){
            return new ResponseEntity<>("Not found by Id",HttpStatus.NOT_FOUND);
        }
        else{
            executorEntityRepository.deleteById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }

    }
    @PatchMapping("/editExecutor")
    public ResponseEntity<?> updateScopeOfWork(@RequestBody ExecutorEntity executorEntity) {
        if (executorEntityRepository.existsById(executorEntity.getIdExecutor())) {
            executorEntityRepository.save(executorEntity);
        } else {
            return new ResponseEntity<>("Scope of work is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(executorEntity, HttpStatus.OK);
    }
}
