package com.woopaloopa.reptileshop.controller;

//import com.woopaloopa.reptileshop.crwaling.ShopCrawling;
import com.woopaloopa.reptileshop.dto.ShopInfoDto;
import com.woopaloopa.reptileshop.service.ShopService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class ShopController {

    private final ShopService shopService;
//    private final ShopCrawling shopCrawling;

    @GetMapping("/shops")
    @ApiOperation(value = "Shop 목록", notes = "샵의 목록을 불러옵니다.", tags = "SHOP")
    public ResponseEntity<List<ShopInfoDto>> selectShops() {
        return new ResponseEntity(shopService.selectShops(), HttpStatus.OK);
    }

    @PostMapping("/shop")
    @ApiOperation(value = "Shop 입력", notes = "샵 입력을 합니다.", tags = "SHOP")
    public ResponseEntity insertShop(@RequestBody ShopInfoDto shop) {
        shopService.insertShopAndHomepage(shop);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/shopCrawling")
//    public ResponseEntity insertShop() {
//        shopCrawling.startCrawling();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
