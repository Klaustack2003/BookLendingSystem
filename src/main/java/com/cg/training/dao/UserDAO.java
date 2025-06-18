package com.cg.training.dao;

import com.cg.training.model.User;

import java.util.List;

/**
 * UserDAO is a Data Access Object interface that defines operations 
 * for managing User entities, including adding a new user and 
 * retrieving all users from the data source.
 * <p>
 * Implementations of this interface provide persistence logic for User records.
 * </p>
 * 
 * @author Jayashree Roy
 */
public interface UserDAO {

    /**
     * Adds a new User to the data source.
     *
     * @param user the User object to be added; must not be null
     * @throws IllegalArgumentException if the user is null or contains invalid data
     */
    void addUser(User user);

    /**
     * Retrieves all Users from the data source.
     *
     * @return a List of User objects; may be empty if no users are found
     */
    List<User> getAllUsers();
}
