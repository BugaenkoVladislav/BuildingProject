package org.kataew.project.repositories;


import org.kataew.project.entities.ExecutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutorRepository extends JpaRepository<ExecutorEntity, Long> {
}