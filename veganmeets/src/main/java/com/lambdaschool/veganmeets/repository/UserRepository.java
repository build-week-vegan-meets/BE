package com.lambdaschool.veganmeets.repository;

import com.lambdaschool.veganmeets.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
