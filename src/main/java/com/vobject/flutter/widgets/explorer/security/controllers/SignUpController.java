package com.vobject.flutter.widgets.explorer.security.controllers;

import java.util.Optional;

import javax.validation.Valid;

import io.reactivex.Single;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import com.vobject.flutter.widgets.explorer.security.dtos.UserDto;
import com.vobject.flutter.widgets.explorer.security.services.UserService;


@Controller("/signup")
@Secured(SecurityRule.IS_ANONYMOUS)
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @Post
    public Single<HttpResponse<UserDto>> registerUser(@Valid UserDto userDto) {

        Optional<UserDto> existingUser = userService.findUser(userDto.getUsername());

        return Single.just(existingUser.isPresent() ? HttpResponse.badRequest()
                         : HttpResponse.ok(userService.createUser(userDto)));
    }
}
