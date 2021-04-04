package com.woopaloopa.reptileshop.domain.shop;

import com.woopaloopa.reptileshop.domain.homepage.Homepage;
import com.woopaloopa.reptileshop.domain.homepage.HomepageRepository;
import java.util.ArrayList;
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
    private HomepageRepository homepageRepository;

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
        String name = "더쥬";
        String streetNameAddress = "경기도 군포시 산본천로 211";
        String lotNumberAddress = "경기도 군포시 산본동 91-41 지하1층";
        String homepage = "https://xn--9m1b023b.com/";
        String time = "매일 10:00 ~ 21:00";
        String info = "더쥬 입니다.";
        List<Homepage> homepages = new ArrayList<>();
        Homepage homepage1 = Homepage.builder()
            .type("홈페이지")
            .address(homepage)
            .build();

        homepages.add(homepage1);
        Shop shop1 = Shop.builder()
            .name(name)
            .lotNumberAddress(streetNameAddress)
            .streetNameAddress(lotNumberAddress)
            .time(time)
            .info(info)
            .build();
        shop1.addHomepage(homepage1);
        shopRepository.save(shop1);
    }

    @Test
    void 샵의_목록을_보여준다() {
        샵_데이터_넣기();
        List<Shop> shops = shopRepository.findAll();
        Assertions.assertEquals(shops.size(), 1);
        Assertions.assertEquals(shops.get(0).getName(), "더쥬");
    }
}