package jpa.embedded;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
  public static void main(String[] args) {
    // <persistence-unit name="hello">
    // Manager Factory 를 만드는 순간 DB와의 연결 같은 것들이 다 됨
    // Application Loading 시점에 딱 하나만 만들어둬야 함
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    //  하나의 일괄적인 단위마다 Entity Manager 를 만들어 줘야 함
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member member = new Member();
      member.setUserName("hello");
      member.setHomeAddress(new Address());
      member.setWorkPeriod(new Period());
      em.persist(member);
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
