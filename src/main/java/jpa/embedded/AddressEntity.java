package jpa.embedded;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
  @Id @GeneratedValue
  private Long id;
  @Embedded
  private Address address;

  public AddressEntity() {
  }
}
