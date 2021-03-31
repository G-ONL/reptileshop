package com.woopaloopa.reptileshop.service;

import com.woopaloopa.reptileshop.domain.shop.Shop;
import com.woopaloopa.reptileshop.domain.shop.ShopRepository;
import com.woopaloopa.reptileshop.dto.ShopInfoDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public List<ShopInfoDto> selectShops() {
        return shopRepository.findAll().stream().map(ShopInfoDto::new).collect(Collectors.toList());
    }

    public void insertShopAndAddress(ShopInfoDto shopInfo) {
        Shop shop = shopInfo.toShopEntity();
        shopRepository.save(shop);
    }
}
