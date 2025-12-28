package de.nadu_ocholt.anbauplaner.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAddress(String emailAddress);

    boolean existsByUsername(String username);

    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByUsername(String username);
}
