package com.BEBuildweek2.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BEBuildweek2.auth.entity.ERole;
import com.BEBuildweek2.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
