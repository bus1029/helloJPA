package jpa.hello;

import javax.persistence.*;
import java.util.Date;

// Entity를 명시해줘야 JPA에서 관리해줌
@Entity
//  테이블 이름을 명시해줄 수 도 있음
//@Table(name = "USER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1
)
public class Member {
  // Primary Key
  @Id
/*  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;*/

  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
  private Long id;

  // 컬럼 이름도 따로 명시 가능
  @Column(name = "name")
  private String username;

  private Integer age;

  // Enum을 쓰고 싶다!
  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  // DATE, TIME, TIMESTAMP(DATE + TIME)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;

  // VARCHAR를 넘는 큰 컨텐츠를 넣고 싶을 때
  // 문자 타입이기 때문에 CLOB
  @Lob
  private String description;

  // 컬럼 매핑이 안됨, 메모리에서만 사용
  @Transient
  private int tmp;

  public Member() {

  }
}