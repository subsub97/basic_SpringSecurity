package org.example.tubesecurity.repository;

import jakarta.persistence.criteria.Join;
import org.example.tubesecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
