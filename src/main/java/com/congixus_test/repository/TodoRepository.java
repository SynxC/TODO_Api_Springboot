package com.congixus_test.repository;

import com.congixus_test.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoItem, String> {
}
