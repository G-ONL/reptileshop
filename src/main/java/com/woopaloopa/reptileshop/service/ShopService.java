package com.woopaloopa.reptileshop.service;

import com.woopaloopa.reptileshop.domain.homepage.Homepage;
import com.woopaloopa.reptileshop.domain.homepage.HomepageRepository;
import com.woopaloopa.reptileshop.domain.shop.Shop;
import com.woopaloopa.reptileshop.domain.shop.ShopRepository;
import com.woopaloopa.reptileshop.dto.ShopInfoDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final HomepageRepository homepageRepository;

    @Transactional
    public List<ShopInfoDto> selectShops() {
        return shopRepository.findAll().stream().map(ShopInfoDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void insertShopAndHomepage(ShopInfoDto shopInfo) {
        Shop shop = shopInfo.toShopEntity();
        shopRepository.save(shop);
        List<Homepage> homepages = shop.getHomepages();
        homepageRepository.saveAll(homepages);
    }
}
