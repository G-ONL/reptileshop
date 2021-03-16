package com.woopaloopa.reptileshop.service;

import com.woopaloopa.reptileshop.domain.ReptileShop;
import com.woopaloopa.reptileshop.repository.ShopRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ShopService {

  private final ShopRepository shopRepository;

  public List<ReptileShop> selectShops() {
    return shopRepository.selectShops();
  }
}
