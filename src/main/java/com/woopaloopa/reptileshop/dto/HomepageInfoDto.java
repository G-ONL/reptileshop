package com.woopaloopa.reptileshop.dto;

import com.woopaloopa.reptileshop.domain.homepage.Homepage;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "인스타그램", name = "홈페이지 타입")
    private String type;
    @ApiModelProperty(example = "http://www.newrungop.com", name = "홈페이지 주소")
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
