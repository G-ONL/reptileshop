package com.woopaloopa.reptileshop.domain.homepage;

import com.woopaloopa.reptileshop.domain.shop.Shop;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomepageRepository extends JpaRepository<Homepage, Long> {

    List<Homepage> findAllByShop(Shop shop);
}
