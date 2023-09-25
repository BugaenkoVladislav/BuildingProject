package org.kataew.project.controllers;

import org.kataew.project.entities.WorkEntity;
import org.kataew.project.repositories.WorkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:5173/")
@RestController
public class WorkController {
    WorkRepository workEntityRepository;
    WorkController(WorkRepository workEntityRepository){
        this.workEntityRepository = workEntityRepository;
    }

    @PostMapping("/addWork")
    public ResponseEntity<String> addWork(@RequestBody WorkEntity work){
        workEntityRepository.save(work);
        return new ResponseEntity<>("addNewWork", HttpStatus.OK);
    }


    @DeleteMapping("/deleteWork")
    public ResponseEntity<String> deleteWork(@RequestBody WorkEntity work){
        WorkEntity workDel = workEntityRepository.findById(work.getIdWork()).get();
        if(workDel.getIdWork() != null){
            workEntityRepository.deleteById(workDel.getIdWork());
            return  new ResponseEntity<>("deleted succesfully", HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>("dont find Id", HttpStatus.CONFLICT);
        }
    }

    @PatchMapping("/updateWork/{id}")
    public  ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody WorkEntity newWork){
        WorkEntity work  = workEntityRepository.findById(id).get();
        if(work != null){

            work.setIdScopeOfWork(newWork.getIdScopeOfWork());
            work.setIdWorkStatus(newWork.getIdWorkStatus());
            work.setName(newWork.getName());
            work.setIdExecutor(newWork.getIdExecutor());
            work.setExpectedDateEnd(newWork.getExpectedDateEnd());
            work.setExpectedDateStart(newWork.getExpectedDateStart());
            work.setIdProject(newWork.getIdProject());
            work.setRealDateStart(newWork.getRealDateStart());
            work.setRealDateEnd(newWork.getRealDateEnd());
            workEntityRepository.save(work);
            return  new ResponseEntity<>("work changed", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("work not found", HttpStatus.CONFLICT);
        }
    }
}
