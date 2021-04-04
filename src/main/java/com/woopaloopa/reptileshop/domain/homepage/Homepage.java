package com.woopaloopa.reptileshop.domain.homepage;

import com.woopaloopa.reptileshop.domain.shop.Shop;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "homepage")
public class Homepage {

    @Id
    @Column(name = "homepage_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long homepageId;

    @ApiModelProperty(example = "인스타그램", name = "홈페이지 타입")
    private String type;

    @ApiModelProperty(example = "http://www.newrungop.com", name = "홈페이지 주소")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Builder
    public Homepage(String type, String address) {
        this.type = type;
        this.address = address;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}
