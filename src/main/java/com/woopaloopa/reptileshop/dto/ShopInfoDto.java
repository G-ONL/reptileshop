package com.woopaloopa.reptileshop.dto;

import com.woopaloopa.reptileshop.domain.address.Address;
import com.woopaloopa.reptileshop.domain.shop.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopInfoDto {

    private Long id;
    private String name;
    private String zip;
    private String address1;
    private String address2;
    private String city;
    private String region;

    public Shop toShopEntity() {
        Address address = toAddressEntity();
        return Shop.builder()
            .name(name)
            .address(address)
            .build();
    }

    public Address toAddressEntity() {
        return Address.builder()
            .address1(address1)
            .address2(address2)
            .city(city)
            .region(region)
            .zip(zip)
            .build();
    }
}
