package com.davidrus.katana.dao;

import com.davidrus.katana.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 24-May-17.
 */
@Repository
public interface UserDao {

    /**
     * Creates a new user in the database
     *
     * @param user the user's details
     */
    boolean createUser(User user);

    /**
     * Fetches the user from the database
     *
     * @param id of the user
     * @return the user
     */
    User getUserById(Long id);

    /**
     * Fetches the user from the database
     *
     * @param userName of the user
     * @return the user
     */
    User getUserByName(String userName);

    /**
     * Updates the user details
     *
     * @param user the user's data
     */
    boolean updateUser(User user);

    /**
     * Deletes the user
     *
     * @param id of the user
     */
    boolean deleteUser(Long id);

}
