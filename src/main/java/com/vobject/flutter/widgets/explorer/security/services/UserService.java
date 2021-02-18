package com.vobject.flutter.widgets.explorer.security.services;

import java.util.Optional;
import javax.inject.Singleton;

import com.vobject.flutter.widgets.explorer.security.domain.User;
import com.vobject.flutter.widgets.explorer.security.dtos.UserDto;
import com.vobject.flutter.widgets.explorer.security.mappers.UserMapper;
import com.vobject.flutter.widgets.explorer.security.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);    

    private final UserRepository usersRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(UserDto userDto) {
        User user = usersRepository.save(userMapper.toEntity(userDto));
        return userMapper.toDto(user);
    }

    public Optional<UserDto> findUser(String username) {
        return usersRepository.findByUsername(username).map(userMapper::toDto);
    }

    public Optional<UserDto> findByRefreshToken(String refreshToken) {
        return usersRepository.findByToken(refreshToken).map(userMapper::toDto);
    }

    public void saveRefreshToken(String username, String refreshToken) {
        usersRepository.findByUsername(username).ifPresent(
                user -> {
                    user.setToken(refreshToken);
                    usersRepository.update(user);
                }
        );
    }
}