package org.kataew.project.repositories;


import org.kataew.project.entities.OrderMaterialStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMaterialStatusRepository extends JpaRepository<OrderMaterialStatusEntity, Long> {
}