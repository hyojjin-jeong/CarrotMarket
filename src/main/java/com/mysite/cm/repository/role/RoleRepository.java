package com.mysite.cm.repository.role;

import com.mysite.cm.entity.member.Role;
import com.mysite.cm.entity.member.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}