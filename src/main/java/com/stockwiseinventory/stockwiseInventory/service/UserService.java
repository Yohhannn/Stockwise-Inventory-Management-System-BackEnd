package com.stockwiseinventory.stockwiseInventory.service;

import com.stockwiseinventory.stockwiseInventory.model.User;
import com.stockwiseinventory.stockwiseInventory.model.UserDTO;

import java.util.List;

public interface UserService {
    User saveAccount(User account);
    String login(String username, String password);
    List<User> getNewUsersThisMonth();
    long getNewUsersCountThisMonth();
    long getActiveUsersCount();
    List<User> getAllUsers();
    User createUser(User user);
    void deleteUser(int userId);
    User updateUser(int userId, User updatedUser);
    List<UserDTO> getAllUsersDefined();

    boolean existsByUsernameOrEmail(String username, String email);
}
