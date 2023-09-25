package org.kataew.project.repositories;


import org.kataew.project.entities.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
}
