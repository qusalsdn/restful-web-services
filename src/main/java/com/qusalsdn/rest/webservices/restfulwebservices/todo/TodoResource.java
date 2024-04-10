package com.qusalsdn.rest.webservices.restfulwebservices.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
