package jpa.jpql;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
// ORDER는 예약어라 안됨
public class Order {

  @Id @GeneratedValue
  private Long id;
  private int orderAmount;

  @Embedded
  private Address address;

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;
}
