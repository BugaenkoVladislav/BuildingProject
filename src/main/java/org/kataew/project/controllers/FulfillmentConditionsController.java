package org.kataew.project.controllers;

import org.kataew.project.entities.AvailableMaterialEntity;
import org.kataew.project.entities.FulfillmentConditionsEntity;
import org.kataew.project.entities.ProviderEntity;
import org.kataew.project.repositories.AvailableMaterialRepository;
import org.kataew.project.repositories.FulfillmentConditionsRepository;
import org.kataew.project.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173/")
@Controller
public class FulfillmentConditionsController {

    private final FulfillmentConditionsRepository fulfillmentConditionsRepository;

    public FulfillmentConditionsController(@Autowired FulfillmentConditionsRepository fulfillmentConditionsRepository) {
        this.fulfillmentConditionsRepository = fulfillmentConditionsRepository;
    }

    @PostMapping("/addFulfillmentCondition")
    public ResponseEntity<String> addFulfillmentCondition(@RequestBody FulfillmentConditionsEntity fulfillmentConditions) {
        fulfillmentConditionsRepository.save(fulfillmentConditions);
        return new ResponseEntity<>("Fulfillment conditions addd", HttpStatus.OK);
    }

    @GetMapping("/getAllFulfillmentConditions/{idWork}")
    public ResponseEntity<?> getAllFulfillmentConditions(@PathVariable Long idWork) {
        List<FulfillmentConditionsEntity> fulfillmentConditionsEntitiesList = fulfillmentConditionsRepository.findFulfillmentConditionsEntitiesByIdWork(idWork);
        return new ResponseEntity<>(fulfillmentConditionsEntitiesList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFulfillmentCondition/{fulfillmentConditionId}")
    public ResponseEntity<?> deleteFulfillmentCondition(@PathVariable Long fulfillmentConditionId) {
        if (fulfillmentConditionsRepository.existsById(fulfillmentConditionId)) {
            fulfillmentConditionsRepository.deleteById(fulfillmentConditionId);
        } else {
            return new ResponseEntity<>("Fulfillment conditions are undefined", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Fulfillment conditions deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateFulfillmentCondition")
    public ResponseEntity<?> updateFulfillmentCondition(@RequestBody FulfillmentConditionsEntity fulfillmentCondition) {
        if (fulfillmentConditionsRepository.existsById(fulfillmentCondition.getIdFulfillmentConditions())) {
            fulfillmentConditionsRepository.save(fulfillmentCondition);
        } else {
            return new ResponseEntity<>("Fulfillment conditions are undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fulfillmentCondition, HttpStatus.OK);
    }
}
