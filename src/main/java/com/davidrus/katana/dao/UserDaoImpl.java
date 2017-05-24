package com.davidrus.katana.dao;

import com.davidrus.katana.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Created by david on 24-May-17.
 */
@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    public EntityManager em;

    /**
     * Creates a new user in the database
     *
     * @param user the user's details
     */
    @Override
    @Transactional
    public boolean createUser(User user) {
        em.persist(user);

        return true;
    }

    /**
     * Fetches the user from the database
     *
     * @param id of the user
     * @return the user
     */
    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_ID, User.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    /**
     * Fetches the user from the database
     *
     * @param userName of the user
     * @return the user
     */
    @Override
    public User getUserByName(String userName) {
        TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_NAME, User.class);
        query.setParameter("name", userName);

        return query.getSingleResult();
    }

    /**
     * Updates the user details
     *
     * @param user the user's data
     */
    @Override
    public boolean updateUser(User user) {
        em.merge(user);

        return true;
    }

    /**
     * Deletes the user
     *
     * @param id of the user
     */
    @Override
    public boolean deleteUser(Long id) {
        TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_ID, User.class);
        query.setParameter("id", id);
        User user = query.getSingleResult();
        em.remove(user);

        return true;
    }
}





