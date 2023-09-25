package org.kataew.project.repositories;


import org.kataew.project.entities.WorkStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkStatusRepository extends JpaRepository<WorkStatusEntity, Long> {
}