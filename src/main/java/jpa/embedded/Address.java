package jpa.embedded;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
  private String city;
  private String street;
  private String zipCode;

  public Address() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return city.equals(address.city) && street.equals(address.street) && zipCode.equals(address.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, street, zipCode);
  }
}
