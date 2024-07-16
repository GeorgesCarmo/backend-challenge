package com.georges.backend_challenge.controller;

import com.georges.backend_challenge.entity.Todo;
import com.georges.backend_challenge.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo) {
        return todoService.crete(todo);
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable Long id){
        return todoService.delete(id);
    }
}
