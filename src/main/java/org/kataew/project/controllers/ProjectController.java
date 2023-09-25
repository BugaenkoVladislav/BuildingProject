package org.kataew.project.controllers;

import org.kataew.project.entities.ProjectEntity;
import org.kataew.project.repositories.ProjectEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    ProjectEntityRepository projectEntityRepository;

    public ProjectController(@Autowired ProjectEntityRepository projectEntityRepository){
        this.projectEntityRepository = projectEntityRepository;
    }


    @PostMapping("/createProject")
    public ResponseEntity<String> createProject(@RequestBody ProjectEntity projectEntity){

        projectEntityRepository.save(projectEntity);


        return new ResponseEntity<>("project created", HttpStatus.OK);
    }

    @GetMapping("/getAllProjects/{projectId}")
    public ResponseEntity<?> getAllProject(@PathVariable Long projectId){

        List<ProjectEntity> projectEntities = projectEntityRepository.getProjectEntitiesByIdUser(projectId);


        return new ResponseEntity<>(projectEntities, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProject/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId){

        projectEntityRepository.deleteById(projectId);

        return new ResponseEntity<>("project deleted",HttpStatus.OK);
    }

    @PatchMapping("/updateProject")
    public ResponseEntity<?> updateProject(@RequestBody ProjectEntity projectEntity){

        if (projectEntityRepository.existsById(projectEntity.getIdProject())){
            projectEntityRepository.save(projectEntity);
        } else {
            return new ResponseEntity<>("project is undefined",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(projectEntity,HttpStatus.OK);
    }

}
