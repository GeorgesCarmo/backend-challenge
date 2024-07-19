package com.georges.backend_challenge.service;

import com.georges.backend_challenge.dto.TodoDTO;
import com.georges.backend_challenge.dto.TodoResponseDTO;
import com.georges.backend_challenge.entity.Todo;
import com.georges.backend_challenge.repository.TodoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public Todo crete(@RequestBody TodoDTO todoDTO) {
    Todo newTodo = new Todo();
    newTodo.setName(todoDTO.name());
    newTodo.setDescription(todoDTO.description());
    newTodo.setCompleted(false);
    newTodo.setPriority(todoDTO.priority());
       return todoRepository.save(newTodo);
    }

    public Page<Todo> list(Pageable pageable){
        return todoRepository.findAll(pageable);
    }

    public ResponseEntity<Todo> update(TodoResponseDTO responseDTO) {

        Todo newTodo = new Todo();
        newTodo.setId(responseDTO.id());
        newTodo.setName(responseDTO.name());
        newTodo.setDescription(responseDTO.description());
        newTodo.setCompleted(responseDTO.completed());
        newTodo.setPriority(responseDTO.priority());
        newTodo.setCreatedAt(LocalDateTime.now());

        return ResponseEntity.ok(todoRepository.save(newTodo));
    }

    public List delete(Long id){
        todoRepository.deleteById(id);
        return listAll();
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public List<Todo> listAll(){
        return todoRepository.findAll();
    }
}
