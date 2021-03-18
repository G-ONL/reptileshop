package com.woopaloopa.reptileshop.domain.shop;

import com.woopaloopa.reptileshop.domain.address.Address;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Shop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String name;

  @OneToOne
  @JoinColumn(name = "address_id")
  private Address address;

  @Builder
  public Shop(String name, Address address) {
    this.name = name;
    this.address = address;
  }
}
