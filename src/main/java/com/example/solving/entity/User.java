package com.example.solving.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> createdTasks;

    @OneToMany
    private List<Task> answeredTasks;

}
