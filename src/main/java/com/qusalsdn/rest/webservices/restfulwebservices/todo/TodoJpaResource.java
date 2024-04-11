package com.qusalsdn.rest.webservices.restfulwebservices.todo;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJpaResource {
    private TodoRepository todoRepository;

    public TodoJpaResource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping(path = "/users/{userName}/todos")
    public List<Todo> retrieveTodos(@PathVariable String userName) {
        return todoRepository.findByUserName(userName);
    }

    @GetMapping(path = "/users/{userName}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String userName, @PathVariable int id) {
        return todoRepository.findById(id).get();
    }

    @DeleteMapping(path = "/users/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/users/{userName}/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping(path = "/users/{userName}/todos")
    public Todo createTodo(@PathVariable String userName, @RequestBody Todo todo) {
        todo.setUserName(userName);
        todo.setId(null);
        return todoRepository.save(todo);
    }
}
