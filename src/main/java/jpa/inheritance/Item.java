package jpa.inheritance;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// 기본적으로 DTYPE 이라는 컬럼으로 생성됨
// 기본적으로 Entity 자식명이 값으로 들어감
// DiscriminatorValue 를 자식에 명시함으로써 입력되는 값을 변경할 수도 있음
@DiscriminatorColumn
public class Item {
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
