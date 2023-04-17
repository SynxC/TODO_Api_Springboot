package com.congixus_test.controller;

import com.congixus_test.model.TodoItem;
import com.congixus_test.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/Add")
    public TodoItem addTodoItem(@RequestBody TodoItem todoItem){
        return todoRepository.save(todoItem);
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
