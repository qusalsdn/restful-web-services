package com.qusalsdn.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 1;

    static {
        users.add(new User(userCount++, "byun", LocalDate.now().minusYears(20)));
        users.add(new User(userCount++, "min", LocalDate.now().minusYears(24)));
        users.add(new User(userCount++, "woo", LocalDate.now().minusYears(27)));
    }

    public User save(User user) {
        user.setId(userCount++);
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
