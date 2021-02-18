package com.vobject.flutter.widgets.explorer.security.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private String content;

    private LocalDate creationDate = LocalDate.now();

    @ManyToOne
    private User user;


    public Message() {
    }

    public Message(String content, User user) {
        this.content = content;
        this.user = user;
    }    

    public Message(Long id, String content, LocalDate creationDate, User user) {
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
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