package jpa.shop.domain;

import jpa.inheritance.per.Item;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {
  private String director;
  private String actor;
}
