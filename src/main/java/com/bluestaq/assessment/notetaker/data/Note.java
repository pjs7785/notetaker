package com.bluestaq.assessment.notetaker.data;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "created", nullable = false)
    @CreationTimestamp
    private Timestamp created;

    @Column(name = "last_edited", nullable = false)
    @UpdateTimestamp
    private Timestamp lastEdited;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public Timestamp getLastEdited() {
        return lastEdited;
    }

    public Timestamp getCreated() {
        return created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
