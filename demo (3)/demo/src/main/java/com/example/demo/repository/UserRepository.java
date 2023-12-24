package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public User save (User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    public User update (User user) {
        users.remove(user.getId());
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();

    }
}
