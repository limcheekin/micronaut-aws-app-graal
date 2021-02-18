package com.vobject.flutter.widgets.explorer.security.repositories;

import java.util.Optional;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import com.vobject.flutter.widgets.explorer.security.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByToken(String token);
}

