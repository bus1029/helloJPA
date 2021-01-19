package jpa.hello;

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
    // Code
    // Insert
    try {
      // 스프링을 사용하면 이런 코드들이 다 사라지고 persist만 하면 됨
      // 나머지는 스프링이 다 알아서 해줌

/*      Member member = new Member();
      member.setId(2L);
      member.setName("HelloB");
      em.persist(member);*/

/*      Member findMember = em.find(Member.class, 1L);
      System.out.println(findMember.getId() + findMember.getName());
      em.remove(findMember);*/

      // Java Collection 처리하듯이 Update 가능
      // 가져온 시점부터 JPA가 해당 Entity들을 관리
      // commit 하는 시점에 JPA가 변경 유무를 모두 확인
/*      Member findMember = em.find(Member.class, 1L);
      findMember.setName("HelloJPA");*/

      // 객체지향적이지 못한 설계로 이뤄지는 persist
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);

      // 외래키를 직접 다루는 상황
      // 이젠 Team을 직접 넣을 수 있음
      Member member = new Member();
      member.setUsername("member1");
//      member.setTeamId(team.getId());
      member.setTeam(team);
      em.persist(member);

      // 조회에도 문제가 발생
      Member findMember = em.find(Member.class, member.getId());
//      Long findTeamId = findMember.getTeamId();
//      Team findTeam = em.find(Team.class, findTeamId);
      Team findTeam = findMember.getTeam();

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
