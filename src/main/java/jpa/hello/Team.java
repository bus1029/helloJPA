package jpa.hello;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity {
  @Id @GeneratedValue
  @Column(name = "TEAM_ID")
  private Long id;
  private String name;

  public Team(String name) {
    this.name = name;
  }

  public Team() {
  }

  // 반대이기 때문에 OneToMany
  // mappedBy -> Member에 있는 team 변수와 연관되어 있다
  @OneToMany(mappedBy = "team")
  private List<Member> members = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }
}
