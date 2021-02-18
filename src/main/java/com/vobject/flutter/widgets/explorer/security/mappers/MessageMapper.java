package com.vobject.flutter.widgets.explorer.security.mappers;

import com.vobject.flutter.widgets.explorer.security.domain.Message;
import com.vobject.flutter.widgets.explorer.security.dtos.MessageDto;

import javax.inject.Singleton;

@Singleton
public class MessageMapper {

    final private UserMapper userMapper;

    public MessageMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Message toEntity(MessageDto messageDto) {
        return new Message(
                messageDto.getId(),
                messageDto.getContent(),
                messageDto.getCreationDate(),
                userMapper.toEntity(messageDto.getUser()));
    }

    public MessageDto toDto(Message message) {
        return new MessageDto(message.getId(),
                message.getContent(),
                message.getCreationDate(),
                userMapper.toDto(message.getUser()));
    }
}
