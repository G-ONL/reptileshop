package com.woopaloopa.reptileshop.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {

  private String zip;
  private String address1;
  private String address2;
  private String city;
  private String region;

}
