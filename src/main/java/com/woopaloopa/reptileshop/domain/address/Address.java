package com.woopaloopa.reptileshop.domain.address;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.woopaloopa.reptileshop.domain.shop.Shop;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String zip;
    private String address1;
    private String address2;
    private String city;
    private String region;

    @OneToOne(mappedBy = "address")
    @JsonManagedReference
    private Shop shop;

    @Builder
    public Address(String zip, String address1, String address2, String city, String region) {
        this.zip = zip;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.region = region;
    }

    @Override
    public String toString() {
        return "Address{" +
            "addressId=" + addressId +
            ", zip='" + zip + '\'' +
            ", address1='" + address1 + '\'' +
            ", address2='" + address2 + '\'' +
            ", city='" + city + '\'' +
            ", region='" + region + '\'' +
            '}';
    }
}
