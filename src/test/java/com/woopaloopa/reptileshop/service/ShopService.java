package com.woopaloopa.reptileshop.service;

import com.woopaloopa.reptileshop.domain.shop.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Test
    void 샵의_목록을_보여준다() {
        Assertions.assertEquals(shopRepository.findAll(), null);
    }


}
