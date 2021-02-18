package com.vobject.flutter.widgets.explorer.security.mappers;

import com.vobject.flutter.widgets.explorer.security.domain.User;
import com.vobject.flutter.widgets.explorer.security.dtos.UserDto;

import javax.inject.Singleton;

@Singleton
public class UserMapper {

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        if (user.getRole() == null) {
            user.setRole(User.DEFAULT_ROLE);
        }
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
