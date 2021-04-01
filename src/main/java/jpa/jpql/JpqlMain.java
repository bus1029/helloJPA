package jpa.jpql;

import jpa.hello.Member;

import javax.persistence.*;

public class JpqlMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
//      Member member = new Member();
//      member.setUsername("member1");
//      em.persist(jpa.jpql.Member.class);

      TypedQuery<Member> query1 = em.createQuery("select m from Member m where m.id = 10 and m.username = :username", Member.class);
      query1.setParameter("username", "member1").getResultList();
//      TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
      // 타입정보가 String, int 혼재되어 있기 떄문
//      Query query3 = em.createQuery("select m.username, m.age from Member m");

      Member result = query1.getSingleResult();
      // Spring Data JPA는 결과값이 없을 경우 null을 반환하거나 Optional을 반환
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
