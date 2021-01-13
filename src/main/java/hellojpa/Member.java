package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

// Entity를 명시해줘야 JPA에서 관리해줌
@Entity
//  테이블 이름을 명시해줄 수 도 있음
//@Table(name = "USER")
public class Member {
  // Primary Key
  @Id
  private Long id;
  // 컬럼 이름도 따로 명시 가능
//  @Column(name = "username")
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
