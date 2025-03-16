package org.springdata.project2_many_to_many_use_case.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Fixed typo here
    private Long id;

    private String desc;
    @Column(length=20 , unique=true)
    private String roleName;

    @ManyToMany
    //@JoinTable(name = "USERS_ROLES") // Uncomment if you want to use a join table
    private List<User> users = new ArrayList<>();
}