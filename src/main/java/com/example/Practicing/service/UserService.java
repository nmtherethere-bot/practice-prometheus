package com.example.Practicing.service;

import com.example.Practicing.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final Map<Long, User> userMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public User createUser(User user) {
        Long id = idGenerator.getAndIncrement();
        user.setId(id);
        userMap.put(id, user);
        return user;
    }

    public User getUser(Long id) {
        return userMap.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User updateUser(Long id, User updatedUser) {
        if (!userMap.containsKey(id)) {
            return null;
        }
        updatedUser.setId(id);
        userMap.put(id, updatedUser);
        return updatedUser;
    }

    public boolean deleteUser(Long id) {
        return userMap.remove(id) != null;
    }
}