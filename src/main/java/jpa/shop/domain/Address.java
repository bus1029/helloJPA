package jpa.shop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
  @Column(length = 10)
  public String city;
  @Column(length = 20)
  public String street;
  @Column(length = 5)
  public String zipcode;

  public Address() {
  }

  public String getCity() {
    return city;
  }

  public String getStreet() {
    return street;
  }

  public String getZipcode() {
    return zipcode;
  }

  /*
    JPA 에서는 항상 프록시의 경우에도 진짜 객체에 전달 될 수 있도록 getter 를 사용해서 equals 를 만드는 것을 추천
    equals 외에도 항상 메소드를 통해 값을 전달할 수 있도록 하는게 좋음
  */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCity(), getStreet(), getZipcode());
  }
}
