/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.controller;

/**
 *
 * @author Audit
 */

import recordingapp.model.User;
import recordingapp.service.UserService;
import recordingapp.view.UserView;

public class UserController {

    private UserService service;
    private UserView view;

    public UserController() {

        service = new UserService();
        view = new UserView();
    }

    public void start() {

        int choice;

        do {

            choice = view.showMenu();

            switch (choice) {

                case 1:
                    addUser();
                    break;

                case 2:
                    viewUsers();
                    break;

                case 3:
                    updateUser();
                    break;

                case 4:
                    deleteUser();
                    break;

                case 0:
                    System.out.println(
                            "Returning to main menu..."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 0);
    }

    private void addUser() {

        User user =
                view.getUserInput();

        service.addUser(user);
    }

    private void viewUsers() {

        view.displayUsers(
                service.getAllUsers()
        );
    }

    private void updateUser() {

        User user =
                view.getUserUpdateInput();

        service.updateUser(user);
    }

    private void deleteUser() {

        int id = view.getUserId();

        service.deleteUser(id);
    }
}