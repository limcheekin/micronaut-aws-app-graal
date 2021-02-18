package com.vobject.flutter.widgets.explorer.security.repositories;

import java.util.List;
import java.util.UUID;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

import com.vobject.flutter.widgets.explorer.security.domain.Message;
import com.vobject.flutter.widgets.explorer.security.domain.User;

@Repository
public interface MessageRepository extends PageableRepository<Message, UUID> {

    List<Message> findAllByUser(User user);
}

