package com.test.repository;

import com.test.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoItem, String> {
}
