package com.footballinventory.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_tbl")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Inventory {


}
