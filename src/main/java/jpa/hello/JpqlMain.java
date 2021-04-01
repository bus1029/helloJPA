package jpa.hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpqlMain {
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
      // Member 객체를 대상으로 쿼리를 작성
      // 전체 회원 검색
/*      List<Member> result = em.createQuery("select m from Member as m", Member.class)
              .getResultList();
      result.forEach(System.out::println);*/

/*      List<Member> result = em.createQuery("select m from Member as m", Member.class)
              // Paging도 쉽게 할 수 있음
              //  방언에 맞게 Query Mdification
              .setFirstResult(5)
              .setMaxResults(8)
              .getResultList();
      result.forEach(System.out::println);*/

      // ID가 2이상인 회원만 검색
/*      List<Member> result = em.createQuery("select m from Member as m where m.id >= 2", Member.class)
              .getResultList();
      result.forEach(m -> System.out.println(m.getId() + ", " + m.getName()));*/

      // 이름이 같은 회원만 검색
/*      List<Member> result = em.createQuery("select m from Member as m where m.name = 'HelloJPA'")
              .getResultList();
      result.forEach(m -> System.out.println(m.getId() + ", " + m.getName()));*/

      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Member> query = cb.createQuery(Member.class);

      Root<Member> m = query.from(Member.class);
      CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
      List<Member> resultList = em.createQuery(cq).getResultList();

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
