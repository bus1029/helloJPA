package jpa.shop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  // 자식입장에선 부모가 하나
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PARENT_ID")
  private Category parent;

  // 부모임장에선 자식이 여러개
  @OneToMany(mappedBy = "parent")
  private List<Category> childs = new ArrayList<>();

  // 실전에선 ManyToMany 매핑은 사용하지 말고 일대다, 다대일 매핑으로 풀어낼 것
  @ManyToMany
  @JoinTable(name = "CATEGORY_ITEM",
          joinColumns = @JoinColumn(name = "CATEGORY_ID"),
          inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
  )
  private List<Item> items = new ArrayList<>();
}
