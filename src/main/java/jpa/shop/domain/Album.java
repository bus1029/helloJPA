package jpa.shop.domain;

import jpa.inheritance.per.Item;

import javax.persistence.Entity;

@Entity
public class Album extends Item {
  private String artist;
  private String etc;
}
