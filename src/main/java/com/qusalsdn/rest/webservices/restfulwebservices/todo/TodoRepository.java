package com.qusalsdn.rest.webservices.restfulwebservices.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUserName(String userName);
}
