package org.springdata.project2_many_to_many_use_case.services;

import org.springdata.project2_many_to_many_use_case.entities.User;
import org.springdata.project2_many_to_many_use_case.entities.Role;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
}