package com.vobject.flutter.widgets.explorer.security.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.inject.Singleton;

import com.vobject.flutter.widgets.explorer.security.domain.Message;
import com.vobject.flutter.widgets.explorer.security.dtos.MessageDto;
import com.vobject.flutter.widgets.explorer.security.mappers.MessageMapper;
import com.vobject.flutter.widgets.explorer.security.repositories.MessageRepository;
import com.vobject.flutter.widgets.explorer.security.repositories.UserRepository;

@Singleton
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final UserRepository userRepository;

    public MessageService(MessageRepository messagesRepository, MessageMapper messageMapper, UserRepository userRepository) {
        this.messageRepository = messagesRepository;
        this.messageMapper = messageMapper;
        this.userRepository = userRepository;
    }

    public List<MessageDto> findAll() {
        List<MessageDto> messageDtos = new ArrayList<>();
        messageRepository.findAll().forEach(message -> messageDtos.add(messageMapper.toDto(message)));
        return messageDtos;
    }

    public List<MessageDto> findAllByUsername(String username) {

        List<MessageDto> messageDtos = new ArrayList<>();

        userRepository.findByUsername(username).ifPresent(user ->
                messageRepository.findAllByUser(user).forEach(message ->
                        messageDtos.add(messageMapper.toDto(message)))
        );

        return messageDtos;
    }

    public Optional<MessageDto> create(String content, String username) {

         return userRepository.findByUsername(username).map(user ->
                                messageRepository.save(new Message(content, user)))
                                .map(messageMapper::toDto);
    }
}