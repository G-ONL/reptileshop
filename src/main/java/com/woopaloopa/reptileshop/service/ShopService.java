package com.woopaloopa.reptileshop.service;

import com.woopaloopa.reptileshop.domain.address.AddressRepository;
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
    private final AddressRepository addressRepository;

    public List<ShopInfoDto> selectShops() {
        return shopRepository.findAll().stream().map(shop ->
            ShopInfoDto.builder()
                .id(shop.getShopId())
                .name(shop.getName())
                .address1(shop.getAddress().getAddress1())
                .address2(shop.getAddress().getAddress2())
                .city(shop.getAddress().getCity())
                .region(shop.getAddress().getRegion())
                .zip(shop.getAddress().getZip())
                .build()
        ).collect(Collectors.toList());
    }

    public void insertShopAndAddress(ShopInfoDto shopInfo) {
        Shop shop = shopInfo.toShopEntity();
        shopRepository.save(shop);
    }
}
