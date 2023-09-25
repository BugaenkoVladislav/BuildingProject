package org.kataew.project.controllers;

import org.kataew.project.entities.OrderMaterialEntity;
import org.kataew.project.repositories.OrderMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderMaterialController {

    private final OrderMaterialRepository orderMaterialEntityRepository;

    public OrderMaterialController(@Autowired OrderMaterialRepository orderMaterialEntityRepository) {
        this.orderMaterialEntityRepository = orderMaterialEntityRepository;
    }

    @PostMapping("/createOrderMaterial")
    public ResponseEntity<String> createOrderMaterial(@RequestBody OrderMaterialEntity orderMaterialEntity) {
        orderMaterialEntityRepository.save(orderMaterialEntity);
        return new ResponseEntity<>("Order material created", HttpStatus.OK);
    }

    @GetMapping("/getAllOrderMaterials/{projectId}")
    public ResponseEntity<?> getAllOrderMaterials(@PathVariable Long projectId) {
        List<OrderMaterialEntity> orderMaterialEntities = orderMaterialEntityRepository.getOrderMaterialEntitiesByIdProject(projectId);
        return new ResponseEntity<>(orderMaterialEntities, HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrderMaterial/{orderId}")
    public ResponseEntity<?> deleteOrderMaterial(@PathVariable Long orderId) {
        orderMaterialEntityRepository.deleteById(orderId);
        return new ResponseEntity<>("Order material deleted", HttpStatus.OK);
    }

    @PatchMapping("/updateOrderMaterial")
    public ResponseEntity<?> updateOrderMaterial(@RequestBody OrderMaterialEntity orderMaterialEntity) {
        if (orderMaterialEntityRepository.existsById(orderMaterialEntity.getIdOrderMaterial())) {
            orderMaterialEntityRepository.save(orderMaterialEntity);
        } else {
            return new ResponseEntity<>("Order material is undefined", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderMaterialEntity, HttpStatus.OK);
    }
}
