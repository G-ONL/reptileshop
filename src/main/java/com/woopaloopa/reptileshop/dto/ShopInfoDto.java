package com.woopaloopa.reptileshop.dto;

import com.woopaloopa.reptileshop.domain.shop.Shop;
import java.util.List;
import java.util.stream.Collectors;
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
    private String streetNameAddress;
    private String lotNumberAddress;
    private String time;
    private String info;
    private List<HomepageInfoDto> homepageList;

    public ShopInfoDto(Shop shop) {
        this.id = shop.getShopId();
        this.name = shop.getName();
        this.homepageList = shop.getHomepages().stream().map(HomepageInfoDto::new).collect(
            Collectors.toList());
    }

    public Shop toShopEntity() {

        Shop shop = Shop.builder()
            .name(name)
            .streetNameAddress(streetNameAddress)
            .lotNumberAddress(lotNumberAddress)
            .time(time)
            .info(info)
            .build();
        homepageList.stream()
            .map(HomepageInfoDto::toHomepageEntity).collect(
            Collectors.toList()).forEach(homepage -> shop.addHomepage(homepage));
        return shop;
    }

}
