package com.vobject.flutter.widgets.explorer.security.config;

import java.util.Arrays;
import java.util.List;
import javax.inject.Singleton;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;

import com.vobject.flutter.widgets.explorer.security.domain.Message;
import com.vobject.flutter.widgets.explorer.security.domain.User;
import com.vobject.flutter.widgets.explorer.security.repositories.MessageRepository;
import com.vobject.flutter.widgets.explorer.security.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DataLoader implements ApplicationEventListener<ServerStartupEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    private final UserRepository usersRepository;
    private final MessageRepository messageRepository;

    public DataLoader(UserRepository usersRepository, MessageRepository messageRepository) {
        this.usersRepository = usersRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {


        List<User> users = Arrays.asList(
                new User("user1", "password1"),
                new User("user2", "password2"),
                new User("user3", "password3")
        );
        usersRepository.saveAll(users);

        List<Message> messages =  Arrays.asList(
                new Message("My name is user1", users.get(0)),
                new Message("My name is user2", users.get(1)),
                new Message("My name is user3", users.get(2))
        );
        messageRepository.saveAll(messages);

        LOG.info("Demo data added : "+users.size()+" users and "+messages.size()+" messages");
    }
}