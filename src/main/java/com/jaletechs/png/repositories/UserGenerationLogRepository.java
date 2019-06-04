package com.jaletechs.png.repositories;

import com.jaletechs.png.entities.UserGenerationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jaletechs on 2019-06-02.
 */
@Repository
public interface UserGenerationLogRepository extends JpaRepository<UserGenerationLog, Integer> {
}
