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

  @OneToOne
  @JoinColumn(name = "DELIVERY_ID")
  private Delivery delivery;

  // 자식입장에선 부모가 하나
  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  private Category parent;

  // 부모임장에선 자식이 여러개
  @OneToMany(mappedBy = "parent")
  private List<Category> childs = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "CATEGORY_ITEM",
          joinColumns = @JoinColumn(name = "CATEGORY_ID"),
          inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
  )
  private List<Item> items = new ArrayList<>();
}
