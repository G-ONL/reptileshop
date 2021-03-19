package com.woopaloopa.reptileshop.controller;

import com.woopaloopa.reptileshop.domain.shop.ShopRepository;
import com.woopaloopa.reptileshop.dto.ShopInfoDto;
import io.restassured.RestAssured;
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
        String city = "군포시";
        String address1 = "경기도 군포시 산본천로 211";
        String address2 = "경기도 군포시 산본동 91-41 지하1층";
        String region = "경기도";
        String zip = "15806";
        String name = "더쥬";

        ShopInfoDto shopInfoDto = ShopInfoDto.builder()
            .city(city)
            .address1(address1)
            .address2(address2)
            .region(region)
            .zip(zip)
            .name(name)
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
        Assertions.assertEquals(shopInfoDtos.get(0).getCity(), "군포시");

    }

}
