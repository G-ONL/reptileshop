package com.woopaloopa.reptileshop.domain.shop;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.woopaloopa.reptileshop.domain.address.Address;
import javax.persistence.CascadeType;
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
  @Column(name = "shopId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long shopId;

  @Column(nullable = false)
  private String name;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "addressId")
  @JsonBackReference
  private Address address;

  @Builder
  public Shop(String name, Address address) {
    this.name = name;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Shop{" +
        "shopId=" + shopId +
        ", name='" + name + '\'' +
        ", address=" + address +
        '}';
  }
}
