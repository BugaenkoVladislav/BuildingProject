package org.kataew.project.repositories;

import org.kataew.project.entities.MaterialCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialCategoryRepository extends JpaRepository<MaterialCategoryEntity, Long> {
}