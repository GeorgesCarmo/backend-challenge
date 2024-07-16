package com.georges.backend_challenge.repository;

import com.georges.backend_challenge.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
