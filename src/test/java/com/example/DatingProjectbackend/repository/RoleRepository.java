package com.example.DatingProjectbackend.repository;

import com.example.DatingProjectbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository // ✅ Ensure this annotation is present
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
