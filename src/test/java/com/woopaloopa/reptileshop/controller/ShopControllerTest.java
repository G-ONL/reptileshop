package com.woopaloopa.reptileshop.controller;

import com.woopaloopa.reptileshop.domain.shop.ShopRepository;
import com.woopaloopa.reptileshop.dto.HomepageInfoDto;
import com.woopaloopa.reptileshop.dto.ShopInfoDto;
import io.restassured.RestAssured;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShopControllerTest {

    @LocalServerPort
    private int serverPort;

    @Autowired
    private ShopRepository shopRepository;

    @BeforeEach
    void Setup() {
        RestAssured.port = serverPort;
    }

    @AfterEach
    public void cleanUp() {
        shopRepository.deleteAll();
    }

    @Test
    void 샵_정보를_입력한다() {
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

        RestAssured
            .given()
            .contentType("application/json; charset=UTF-8")
            .request()
            .body(shopInfoDto)
            .when()
            .post("/shop")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    void 샵_목록을_받는다() {
        샵_정보를_입력한다();
        List<ShopInfoDto> shopInfoDtos = RestAssured
            .given()
            .when()
            .get("/shops")
            .then()
            .statusCode(HttpStatus.OK.value())
            .extract()
            .jsonPath().getList(".", ShopInfoDto.class);
        Assertions.assertEquals(shopInfoDtos.size(), 1);
        Assertions.assertEquals(shopInfoDtos.get(0).getName(), "더쥬");
        Assertions.assertEquals(shopInfoDtos.get(0).getHomepageList().get(0).getType(), "홈페이지");

    }

}
