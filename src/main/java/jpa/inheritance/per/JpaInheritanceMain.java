package jpa.inheritance.per;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaInheritanceMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Movie movie = new Movie();
      movie.setDirector("A");
      movie.setActor("B");
      movie.setName("!!!!!");
      movie.setPrice(10000);
      em.persist(movie);

      em.flush();
      em.clear();

      // 부모 클래스를 찾으려고 하면 모든 테이블들을 다 뒤져봐야 함
      // => 엄청 복잡한 쿼리가 발행됨
      Item findItem = em.find(Item.class, movie.getId());

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
