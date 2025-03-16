package org.springdata.project2_many_to_many_use_case.repositories;

import org.springdata.project2_many_to_many_use_case.entities.Role;
import org.springdata.project2_many_to_many_use_case.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String userName);

}