package de.nadu_ocholt.anbauplaner.domain.plant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    boolean existsByName(String name);
}
