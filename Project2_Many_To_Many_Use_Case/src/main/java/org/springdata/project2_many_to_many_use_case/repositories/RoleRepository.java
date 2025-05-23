package org.springdata.project2_many_to_many_use_case.repositories;

import org.springdata.project2_many_to_many_use_case.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);

}