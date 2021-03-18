package com.woopaloopa.reptileshop.service;

import com.woopaloopa.reptileshop.domain.shop.ShopRepository;
import com.woopaloopa.reptileshop.dto.ShopInfoDto;
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
        String city = "군포시";
        String address1 = "경기도 군포시 산본천로 211";
        String address2 = "경기도 군포시 산본동 91-41 지하1층";
        String region = "경기도";
        String zip = "15806";
        String name = "더쥬";
        ShopInfoDto shopInfoDto = ShopInfoDto.builder()
            .name(name)
            .city(city)
            .address1(address1)
            .address2(address2)
            .region(region)
            .zip(zip)
            .build();

        //when
        shopService.insertShopAndAddress(shopInfoDto);

        //then
        List<ShopInfoDto> shops = shopService.selectShops();
        Assertions.assertEquals(shops.size(), 1);
        Assertions.assertEquals(shops.get(0).getAddress1(), shopInfoDto.getAddress1());
    }


}
