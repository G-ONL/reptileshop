package com.woopaloopa.reptileshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zip;
    private String address1;
    private String address2;
    private String city;
    private String region;

    @Builder
    public Address(String zip, String address1, String address2, String city, String region) {
        this.zip = zip;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.region = region;
    }
}
