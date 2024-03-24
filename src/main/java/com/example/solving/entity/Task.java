package com.example.solving.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String fileUrl;
    private LocalDateTime createdTime;

    @ManyToOne
    private User createdBy;

    @OneToOne
    private Answer answer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;


}
