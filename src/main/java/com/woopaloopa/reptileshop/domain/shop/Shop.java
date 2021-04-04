package com.woopaloopa.reptileshop.domain.shop;

import com.woopaloopa.reptileshop.domain.homepage.Homepage;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopId;

    @ApiModelProperty(example = "파충류샵 뉴런지오피", name = "샵 이름")
    @Column(nullable = false)
    private String name;

    @ApiModelProperty(example = "경기 성남시 분당구 성남대로926번길 6 4층 416호", name = "도로명주소(신주소)")
    @Column
    private String streetNameAddress;

    @ApiModelProperty(example = "경기 성남시 분당구 야탑동 361-5 4층 416호", name = "지번주소(구주소)")
    @Column
    private String lotNumberAddress;

    @ApiModelProperty(example = "매일 10:00 ~ 21:00 월요일 휴무", name = "운영시간")
    @Column(columnDefinition = "TEXT")
    private String time;

    @ApiModelProperty(example = "0507-1358-5076", name = "샵 번호")
    @Column
    private String phoneNumber;

    @ApiModelProperty(example = "파충류샵 뉴런지오피 샵입니다", name = "샵 정보(비고)")
    @Column
    private String info;

    @ApiModelProperty(example = "", name = "홈페이지 목록")
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Homepage> homepages = new ArrayList<>();

    @Builder
    public Shop(String name, String streetNameAddress, String lotNumberAddress, String time,
        String info, String phoneNumber, List<Homepage> homepages) {
        this.name = name;
        this.streetNameAddress = streetNameAddress;
        this.lotNumberAddress = lotNumberAddress;
        this.time = time;
        this.info = info;
        this.phoneNumber = phoneNumber;
        this.homepages = homepages == null ? new ArrayList<>() : homepages;
    }

    public void addHomepage(Homepage homepage) {
        this.homepages.add(homepage);
        homepage.setShop(this);
    }
}
