/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.service;

/**
 *
 * @author Audit
 */
import recordingapp.model.User;
import recordingapp.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public void addUser(User user) {

        if (user.getUsername() == null ||
            user.getUsername().trim().isEmpty()) {

            System.out.println(
                    "Username cannot be empty."
            );

            return;
        }

        if (user.getPassword() == null ||
            user.getPassword().trim().isEmpty()) {

            System.out.println(
                    "Password cannot be empty."
            );

            return;
        }

        repository.addUser(user);
    }

    public List<User> getAllUsers() {

        return repository.getAllUsers();
    }

    public void updateUser(User user) {

        repository.updateUser(user);
    }

    public void deleteUser(int userId) {

        repository.deleteUser(userId);
    }
}