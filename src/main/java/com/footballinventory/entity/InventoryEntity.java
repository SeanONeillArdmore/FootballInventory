package com.footballinventory.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "inventory_tbl")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class InventoryEntity {

    @Id
    @Column(name = "id_col")
    private String id;

    @Id
    @Column(name = "id_team")
    private String team;

    @Id
    @Column(name = "id_size")
    private String size;

    @Id
    @Column(name = "id_color")
    private String color;

    public InventoryEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(team, that.team) && Objects.equals(size, that.size) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, team, size, color);
    }
}
