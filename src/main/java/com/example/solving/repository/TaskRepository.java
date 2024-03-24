package com.example.solving.repository;

import com.example.solving.entity.Comment;
import com.example.solving.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByCommentsContaining(Comment comment);
}
