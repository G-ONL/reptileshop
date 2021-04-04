package com.woopaloopa.reptileshop.dto;

import com.woopaloopa.reptileshop.domain.shop.Shop;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "파충류샵 뉴런지오피", name = "샵 이름")
    private String name;
    @ApiModelProperty(example = "경기 성남시 분당구 성남대로926번길 6 4층 416호", name = "도로명주소(신주소)")
    private String streetNameAddress;
    @ApiModelProperty(example = "경기 성남시 분당구 야탑동 361-5 4층 416호", name = "지번주소(구주소)")
    private String lotNumberAddress;
    @ApiModelProperty(example = "매일 10:00 ~ 21:00 월요일 휴무", name = "운영시간")
    private String time;
    @ApiModelProperty(example = "파충류샵 뉴런지오피 샵입니다", name = "샵 정보(비고)")
    private String info;
    @ApiModelProperty(example = "0507-1358-5076", name = "샵 번호")
    private String phoneNumber;
    @ApiModelProperty(example = "", name = "홈페이지 목록")
    private List<HomepageInfoDto> homepageList;

    public ShopInfoDto(Shop shop) {
        this.id = shop.getShopId();
        this.name = shop.getName();
        this.streetNameAddress = shop.getStreetNameAddress();
        this.lotNumberAddress = shop.getLotNumberAddress();
        this.time = shop.getTime();
        this.info = shop.getInfo();
        this.phoneNumber = shop.getPhoneNumber();
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
            .phoneNumber(phoneNumber)
            .build();
        homepageList.stream()
            .map(HomepageInfoDto::toHomepageEntity).collect(
            Collectors.toList()).forEach(homepage -> shop.addHomepage(homepage));
        return shop;
    }

}
