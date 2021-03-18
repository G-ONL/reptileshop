package com.woopaloopa.reptileshop.domain.shop;

import com.woopaloopa.reptileshop.domain.address.Address;
import com.woopaloopa.reptileshop.domain.address.AddressRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ShopRepositoryTest {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private AddressRepository addressRepository;

    @AfterEach
    public void cleanUp() {
        shopRepository.deleteAll();
    }

    @Test
    public void 샵_저장_불러오기() {
        //given
        샵_데이터_넣기();

        //when
        Shop shop = shopRepository.findById(1L).get();
        Assertions.assertEquals(shop.getName(), "더쥬");

        List<Shop> shops = shopRepository.findAll();
        //then
        Shop shop1 = shops.get(0);
        Assertions.assertEquals(shop1.getName(), "더쥬");
    }

    void 샵_데이터_넣기() {
        String city = "군포시";
        String address1 = "경기도 군포시 산본천로 211";
        String address2 = "경기도 군포시 산본동 91-41 지하1층";
        String region = "경기도";
        String zip = "15806";
        String name = "더쥬";
        Address testAddress = Address.builder()
            .city(city)
            .address1(address1)
            .address2(address2)
            .region(region)
            .zip(zip)
            .build();
        Address testAddress2 = Address.builder()
            .city(city)
            .address1(address1)
            .address2(address2)
            .region(region)
            .zip(zip)
            .build();
        Shop shop1 = Shop.builder()
            .name("더쥬")
            .address(testAddress)
            .build();
        Shop shop2 = Shop.builder()
            .name("하마")
            .address(testAddress2)
            .build();
        shopRepository.save(shop1);
        shopRepository.save(shop2);
    }

    @Test
    void 샵의_목록을_보여준다() {
        샵_데이터_넣기();

        List<Shop> shops = shopRepository.findAll();

        Assertions.assertEquals(shops.size(), 2);
        Assertions.assertEquals(shops.get(0).getName(), "더쥬");
    }
}