package jpa.shop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {
  @Id @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;
  @Column(name = "MEMBER_ID")
  private Long memberId;

  // 객체지향적인 설계 필요
/*  private Member member;

  public Member getMember() {
    return member;
  }*/

  private LocalDateTime orderDate; // 스프링부트에선 생성 관례를 덮어쓸 수 있음, (ORDER_DATE, order_date) 스프링부트는 _ 가 기본
  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMemberId() {
    return memberId;
  }

  public void setMemberId(Long memberId) {
    this.memberId = memberId;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }
}
