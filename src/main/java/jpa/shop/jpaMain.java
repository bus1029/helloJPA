package jpa.shop;

import jpa.shop.domain.Order;
import jpa.shop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {
  public static void main(String[] args) {
    // <persistence-unit name="hello">
    // Manager Factory 를 만드는 순간 DB와의 연결 같은 것들이 다 됨
    // Application Loading 시점에 딱 하나만 만들어둬야 함
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaShop");
    //  하나의 일괄적인 단위마다 Entity Manager 를 만들어 줘야 함
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    // Code
    // Insert
    try {
      // 스프링을 사용하면 이런 코드들이 다 사라지고 persist만 하면 됨
      // 나머지는 스프링이 다 알아서 해줌
//      Order order = em.find(Order.class, 1L);
//      Long memberId = order.getMemberId();
      // 객체지향스럽지 못함
//      Member member = em.find(Member.class, memberId);

      // 객체지향!
//      Member member = order.getMember();

      Order order = new Order();
      em.persist(order);
      // 편의 메소드를 사용해서 양방향에 편하게 추가
//      order.addOrderItem(new OrderItem());

      // 양방향 연관관계를 사용하지 않더라도 충분히 대체 가능
      OrderItem orderItem = new OrderItem();
      orderItem.setOrder(order);
      em.persist(orderItem);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
