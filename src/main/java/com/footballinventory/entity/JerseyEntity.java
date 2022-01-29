package com.footballinventory.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "jersey_tbl")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class JerseyEntity {

    @Id
    @Column(name = "id_col")
    private String id;

    @Column(name = "team_col")
    private String team;

    @Column(name = "size_col")
    private String size;

    @Column(name = "color_col")
    private String color;

    public JerseyEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
