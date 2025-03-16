package org.springdata.project2_many_to_many_use_case.services;


import org.springdata.project2_many_to_many_use_case.entities.User;
import org.springdata.project2_many_to_many_use_case.entities.Role;
import org.springdata.project2_many_to_many_use_case.repositories.UserRepository;
import org.springdata.project2_many_to_many_use_case.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUserName(username);
        Role role = roleRepository.findByRoleName(roleName);

        if (user != null && role != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
=
            userRepository.save(user);
            roleRepository.save(role);
        }
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user==null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}