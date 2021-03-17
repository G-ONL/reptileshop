package com.woopaloopa.reptileshop.service;

import com.woopaloopa.reptileshop.domain.shop.Shop;
import com.woopaloopa.reptileshop.domain.shop.ShopRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ShopService {

  private final ShopRepository shopRepository;

  public List<Shop> selectShops() {
    return shopRepository.findAll();
  }
}
