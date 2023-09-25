package org.kataew.project.repositories;

import org.kataew.project.entities.OrderMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMaterialRepository extends JpaRepository<OrderMaterialEntity, Long> {

    List<OrderMaterialEntity> getOrderMaterialEntitiesByIdProject(Long id);
}