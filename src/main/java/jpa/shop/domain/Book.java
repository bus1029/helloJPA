package jpa.shop.domain;

import jpa.inheritance.per.Item;

import javax.persistence.Entity;

@Entity
public class Book extends Item {
  private String author;
  private String isbn;
}
