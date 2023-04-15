package com.congixus_test.controller;

import com.congixus_test.model.Todo;
import com.congixus_test.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @PostMapping
    public Todo addTodoItem(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

    @DeleteMapping
    public void deleteTodoItem(@PathVariable String id){
        todoRepository.deleteById(id);
    }

    @GetMapping
    public List<Todo> getAllTodoItems(){
        return todoRepository.findAll();
    }

    @PutMapping("/{id}/completed")
    public Todo markTodoItem(@PathVariable String id){
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null){
            todo.setCompleted(true);
            return todoRepository.save(todo);
        }
        return null;
    }


}
