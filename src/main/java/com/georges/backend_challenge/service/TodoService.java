package com.georges.backend_challenge.service;

import com.georges.backend_challenge.entity.Todo;
import com.georges.backend_challenge.repository.TodoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> crete(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by("priority").ascending();
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }

    public Todo findById(Long id) throws BadRequestException {
        return todoRepository.findById(id).orElseThrow(()-> new BadRequestException("Todo not found!"));
    }
}
