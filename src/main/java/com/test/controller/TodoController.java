package com.test.controller;

import com.test.model.TodoItem;
import com.test.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/Add")
    public TodoItem addTodoItem(@RequestBody TodoItem todoItem){
        try {
            if (todoItem.getId() == null) {
                return todoRepository.save(todoItem);
            }
            throw new IllegalArgumentException("ID provided error");
        }
        catch(IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Illegal Argument", e);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown Error, please try again later", e);
        }
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteTodoItem(@PathVariable String id){
        todoRepository.deleteById(id);
    }

    @GetMapping("/List")
    public List<TodoItem> getAllTodoItems(){
        return todoRepository.findAll();
    }

    @PutMapping("/Mark-complete/{id}")
    public TodoItem markTodoItem(@PathVariable String id){
        TodoItem todoItem = todoRepository.findById(id).orElse(null);
        if (todoItem != null){
            todoItem.setCompleted(true);
            return todoRepository.save(todoItem);
        }
        return null;
    }


}
