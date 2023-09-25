package org.kataew.project.controllers;


import org.kataew.project.entities.OrderMaterialStatusEntity;
import org.kataew.project.repositories.OrderMaterialStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173/")
@Controller
public class OrderMaterialStatusController {

    private final OrderMaterialStatusRepository orderMaterialStatusRepository;

    public OrderMaterialStatusController(@Autowired OrderMaterialStatusRepository orderMaterialStatusRepository) {
        this.orderMaterialStatusRepository = orderMaterialStatusRepository;
    }

    @PostMapping("/createOrderMaterialStatus")
    public ResponseEntity<String> createOrderMaterialStatus(@RequestBody OrderMaterialStatusEntity orderMaterialStatusEntity) {
        orderMaterialStatusRepository.save(orderMaterialStatusEntity);
        return new ResponseEntity<>("Order material status created", HttpStatus.OK);
    }

    @GetMapping("/getAllOrderMaterialStatuses")
    public ResponseEntity<?> getAllOrderMaterialStatuses() {
        List<OrderMaterialStatusEntity> orderMaterialStatusEntities = orderMaterialStatusRepository.findAll();
        return new ResponseEntity<>(orderMaterialStatusEntities, HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrderMaterialStatus/{orderMaterialStatusId}")
    public ResponseEntity<?> deleteOrderMaterialStatus(@PathVariable Long orderMaterialStatusId) {
        orderMaterialStatusRepository.deleteById(orderMaterialStatusId);
        return new ResponseEntity<>("Order material status deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateOrderMaterialStatus")
    public ResponseEntity<?> updateOrderMaterialStatus(@RequestBody OrderMaterialStatusEntity orderMaterialStatusEntity) {
        if (orderMaterialStatusRepository.existsById(orderMaterialStatusEntity.getIdOrderMaterialStatus())) {
            orderMaterialStatusRepository.save(orderMaterialStatusEntity);
        } else {
            return new ResponseEntity<>("Order material status is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderMaterialStatusEntity, HttpStatus.OK);
    }
}
