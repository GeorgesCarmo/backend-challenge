package com.georges.backend_challenge.controller;

import com.georges.backend_challenge.dto.TodoDTO;
import com.georges.backend_challenge.dto.TodoResponseDTO;
import com.georges.backend_challenge.entity.Todo;
import com.georges.backend_challenge.service.TodoService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    ResponseEntity<Object> create(@RequestBody @Valid TodoDTO todoDTO) {
        return new ResponseEntity<>(todoService.crete(todoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<Page<Todo>> list(Pageable pageable){
        return ResponseEntity.ok(todoService.list(pageable));
    }

    @PutMapping("{id}")
    ResponseEntity<Object> update(@RequestBody TodoResponseDTO responseDTO, @PathVariable Long id) throws BadRequestException {
                return new ResponseEntity<>(todoService.update(responseDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    ResponseEntity<List<Todo>> delete(@PathVariable Long id){
        return new ResponseEntity<>(todoService.delete(id), HttpStatus.OK);
    }
}
