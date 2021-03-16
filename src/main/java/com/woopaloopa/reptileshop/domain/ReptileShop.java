package com.woopaloopa.reptileshop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class ReptileShop {

  @Id
  private long id;
  private String name;

}
