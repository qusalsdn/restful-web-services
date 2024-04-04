package com.qusalsdn.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "byun", LocalDate.now().minusYears(20)));
        users.add(new User(2, "min", LocalDate.now().minusYears(24)));
        users.add(new User(3, "woo", LocalDate.now().minusYears(27)));
    }

    public List<User> findAll() {
        return users;
    }
}
