package com.jaletechs.png.repositories;

import com.jaletechs.png.entities.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jaletechs on 2019-06-01.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User getByEmail(String email);

}
