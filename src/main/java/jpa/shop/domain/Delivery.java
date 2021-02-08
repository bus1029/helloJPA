package jpa.shop.domain;

import javax.persistence.*;

@Entity
public class Delivery {
  @Id @GeneratedValue
  private Long id;
  @Embedded
  private Address address;

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
  private Order order;

  @Enumerated(EnumType.STRING)
  private DeliveryStatus status;
}
