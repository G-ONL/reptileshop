package com.woopaloopa.reptileshop.controller;

import com.woopaloopa.reptileshop.domain.shop.Shop;
import com.woopaloopa.reptileshop.service.ShopService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/shops")
    public ResponseEntity<List<Shop>> selectShops() {
        return new ResponseEntity<>(shopService.selectShops(), HttpStatus.OK);

    }


}
