package com.bluestaq.assessment.notetaker.repositories;

import com.bluestaq.assessment.notetaker.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String username);
}
