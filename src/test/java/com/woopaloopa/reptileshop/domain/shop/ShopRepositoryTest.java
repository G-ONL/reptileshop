package com.woopaloopa.reptileshop.domain.shop;

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

    @AfterEach
    public void cleanUp() {
        shopRepository.deleteAll();
    }

    @Test
    public void 샵_저장_불러오기() {
        //given
        String shopName = "더쥬";

        shopRepository.save(Shop.builder()
            .name(shopName)
            .build());

        //when
        List<Shop> shops = shopRepository.findAll();

        //then
        Shop shop = shops.get(0);
        Assertions.assertEquals(shop.getName(), shopName);
    }
}