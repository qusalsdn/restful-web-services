package com.qusalsdn.rest.webservices.restfulwebservices.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "/users/{userName}/todos")
    public List<Todo> retrieveTodos(@PathVariable String userName) {
        return todoService.findByUserName(userName);
    }

    @GetMapping(path = "/users/{userName}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String userName, @PathVariable int id) {
        return todoService.findById(id);
    }

    @DeleteMapping(path = "/users/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/users/{userName}/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        todoService.updateTodo(todo);
        return todo;
    }

    @PostMapping(path = "/users/{userName}/todos")
    public Todo updateTodo(@PathVariable String userName, @RequestBody Todo todo) {
        Todo createdTodo = todoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return createdTodo;
    }
}
