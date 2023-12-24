package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



    @Repository
    public class UserRepository {
        private final List<User> users = new ArrayList<>();

        public User save(User user) {
            if (user.getId() == null) {
                // Jika ID null, ini adalah operasi create (penyimpanan baru)
                user.setId((long) (users.size() + 1));
                users.add(user);
            } else {
                // Jika ID tidak null, ini adalah operasi update
                Optional<User> existingUser = findById(user.getId());
                if (existingUser.isPresent()) {
                    // Hapus user yang ada dengan ID yang sama
                    users.remove(existingUser.get());
                    // Tambahkan user yang diperbarui
                    users.add(user);
                } else {
                    // Handle jika user dengan ID yang diberikan tidak ditemukan
                    throw new RuntimeException("User not found with ID: " + user.getId());
                }
            }

            return user;
        }

        public List<User> findAll() {
            return users;
        }

        public Optional<User> findById(Long id) {
            return users.stream().filter(user -> user.getId().equals(id)).findFirst();
        }

        public boolean existsById(Long id) {
            return users.stream().anyMatch(user -> user.getId().equals(id));
        }
    }
