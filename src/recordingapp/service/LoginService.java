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
import recordingapp.repository.LoginRepository;

public class LoginService {

    private LoginRepository repository;

    public LoginService() {
        repository = new LoginRepository();
    }

    public User login(
            String username,
            String password) {

        if (username == null ||
            username.trim().isEmpty()) {

            System.out.println(
                    "Username cannot be empty."
            );

            return null;
        }

        if (password == null ||
            password.trim().isEmpty()) {

            System.out.println(
                    "Password cannot be empty."
            );

            return null;
        }

        return repository.login(
                username,
                password
        );
    }

    public boolean usernameExists(
            String username) {

        return repository.usernameExists(
                username
        );
    }
}