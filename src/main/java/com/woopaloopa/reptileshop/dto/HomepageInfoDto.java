package com.woopaloopa.reptileshop.dto;

import com.woopaloopa.reptileshop.domain.homepage.Homepage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomepageInfoDto {

    private Long id;
    private String type;
    private String address;


    public HomepageInfoDto(Homepage homepage) {
        this.id = homepage.getHomepageId();
        this.type = homepage.getType();
        this.address = homepage.getAddress();
    }

    public Homepage toHomepageEntity() {
        return Homepage.builder()
            .type(type)
            .address(address)
            .build();
    }
}
