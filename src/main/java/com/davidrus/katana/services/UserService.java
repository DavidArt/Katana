package com.davidrus.katana.services;

import com.davidrus.katana.dto.User;
import org.springframework.stereotype.Service;

/**
 * Created by david on 17-May-17.
 */
@Service
public interface UserService {
    boolean createUser(User user);

    User getUser(Long id);

    User getUserByName(String name);

    boolean updateUser(User user);

    boolean deleteUser(Long id);

}
