package com.chatapplication.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        userRepository.save(user);
    }

    public boolean login(String userId, String password) {
        Optional<User> userById = userRepository.findUserByIdAndPassword(userId, password);

        if (userById.isPresent() && !userById.get().isLoggedIn()) {
            User user = userById.get();
            user.setLoggedIn(true);
            userRepository.save(user);
            return true;
        }

        return false;
    }

    public List<User> getAllUsers() {
        Iterable<User> all = userRepository.findAll();
        List<User> users = new ArrayList<>();
        all.forEach(users::add);
        return users;
    }

    public User getUser(String userId) {
        Optional<User> byId = userRepository.findById(userId);
        return byId.orElse(null);
    }

    public void logOut(String userId) {
        userRepository.findById(userId).ifPresent(u -> {
            u.setLoggedIn(false);
            userRepository.save(u);
        });
    }
}
