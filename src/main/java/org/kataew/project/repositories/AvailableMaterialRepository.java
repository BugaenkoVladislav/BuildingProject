package org.kataew.project.repositories;

import org.kataew.project.entities.AvailableMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableMaterialRepository extends JpaRepository<AvailableMaterialEntity, Long> {
    List<AvailableMaterialEntity> findAvailableMaterialEntitiesByIdProject(Long id);
}
