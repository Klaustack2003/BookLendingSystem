package com.cg.training.daoImplementation;

import com.cg.training.dao.UserDAO;
import com.cg.training.model.User;

import java.util.*;

/**
 * Implementation of the {@link UserDAO} interface for managing User entities
 * in-memory.
 * <p>
 * This class maintains an internal list of User objects and provides methods 
 * to add users and retrieve all users.
 * </p>
 * 
 * @author Jayashree Roy
 */
public class UserDAOImplementation implements UserDAO {

    private final List<User> users = new ArrayList<>();

    /**
     * Adds a User to the internal list.
     *
     * @param user the User object to be added; must not be null
     * @throws IllegalArgumentException if the user is null
     */
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Retrieves all users currently stored.
     *
     * @return an unmodifiable list of all User objects; may be empty if no users exist
     */
    @Override
    public List<User> getAllUsers() {
        return Collections.unmodifiableList(users);
    }
}
