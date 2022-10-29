package com.chatapplication.group;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    private String id;
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    @PrePersist
    void beforeSave() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
