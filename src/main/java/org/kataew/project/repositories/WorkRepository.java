package org.kataew.project.repositories;


import org.kataew.project.entities.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
}
