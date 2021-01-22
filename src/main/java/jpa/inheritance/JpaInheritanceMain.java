package jpa.inheritance;

import jpa.hello.Member;
import jpa.hello.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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

      //JOIN 해서 가져옴
      Movie findMovie = em.find(Movie.class, movie.getId());

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
