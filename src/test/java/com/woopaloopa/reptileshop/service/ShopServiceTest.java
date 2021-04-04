package com.woopaloopa.reptileshop.service;

import com.woopaloopa.reptileshop.domain.shop.ShopRepository;
import com.woopaloopa.reptileshop.dto.HomepageInfoDto;
import com.woopaloopa.reptileshop.dto.ShopInfoDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopServiceTest {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopRepository shopRepository;

    @AfterEach
    public void cleanUp() {
        shopRepository.deleteAll();
    }

    @Test
    void 샵_정보_입력() {
        //given
        String streetNameAddress = "경기도 군포시 산본천로 211";
        String lotNumberAddress = "경기도 군포시 산본동 91-41 지하1층";
        String homepage1 = "https://xn--9m1b023b.com/";
        String info = "더쥬 입니다.";
        String name = "더쥬";
        String time = "매일 10:00 ~ 21:00";

        List<HomepageInfoDto> homepageInfoDtos = new ArrayList<>();

        HomepageInfoDto homepageInfoDto = HomepageInfoDto.builder()
            .address(homepage1)
            .type("홈페이지")
            .build();
        homepageInfoDtos.add(homepageInfoDto);

        ShopInfoDto shopInfoDto = ShopInfoDto.builder()
            .homepageList(homepageInfoDtos)
            .name(name)
            .lotNumberAddress(lotNumberAddress)
            .streetNameAddress(streetNameAddress)
            .info(info)
            .time(time)
            .build();

        //when
        shopService.insertShopAndHomepage(shopInfoDto);

        //then
        List<ShopInfoDto> shops = shopService.selectShops();
        Assertions.assertEquals(shops.size(), 1);
        Assertions.assertEquals(shops.get(0).getHomepageList().get(0).getAddress(),
            shopInfoDto.getHomepageList().get(0).getAddress());
    }


}
