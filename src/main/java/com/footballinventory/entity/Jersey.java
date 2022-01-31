package com.footballinventory.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Jersey {

    @Id
    private String id;

    private String team;

    private String size;

    private String color;

    public Jersey() {
        this.id = UUID.randomUUID().toString();
    }
}
