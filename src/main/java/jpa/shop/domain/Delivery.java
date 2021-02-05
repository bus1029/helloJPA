package jpa.shop.domain;

import javax.persistence.*;

@Entity
public class Delivery {
  @Id @GeneratedValue
  private Long id;

  private String city;
  private String street;
  private String zipCode;

  @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
  private Order order;

  @Enumerated(EnumType.STRING)
  private DeliveryStatus status;
}
