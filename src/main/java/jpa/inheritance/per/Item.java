package jpa.inheritance.per;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// 기본적으로 DTYPE 이라는 컬럼으로 생성됨
// 기본적으로 Entity 자식명이 값으로 들어감
// 추상클래스로 만드는게 맞음
// Item 에서 공통으로 나온 변수들만 사용하기 때문에
public abstract class Item {
  @Id @GeneratedValue
  private Long id;

  private String name;
  private int price;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
