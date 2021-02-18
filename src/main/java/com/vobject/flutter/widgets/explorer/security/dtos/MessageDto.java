package com.vobject.flutter.widgets.explorer.security.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micronaut.core.annotation.Introspected;

@Introspected
//@JsonIgnoreProperties({"user"})
public class MessageDto {

    @NotNull
    private Long id;
    @NotBlank
    private String content;
    @NotNull
    private LocalDate creationDate;
    @NotNull
    private UserDto user;


    public MessageDto() {
    }

    public MessageDto(Long id, String content, LocalDate creationDate, UserDto user) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", content='" + getContent() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}
