package com.georges.backend_challenge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Campo obrigatório")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Campo obrigatório")
    private String description;

    @Column(nullable = false)
    private Boolean completed;

    @Column(nullable = false)
    private String priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Todo(String name, String description, Boolean completed, String priority) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }
}
