package com.woopaloopa.reptileshop.domain.shop;

import com.woopaloopa.reptileshop.domain.homepage.Homepage;
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

    @Column(nullable = false)
    private String name;

    @Column
    private String streetNameAddress;

    @Column
    private String lotNumberAddress;

    @Column
    private String time;

    @Column
    private String info;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Homepage> homepages = new ArrayList<>();

    @Builder
    public Shop(String name, String streetNameAddress, String lotNumberAddress, String time,
        String info, List<Homepage> homepages) {
        this.name = name;
        this.streetNameAddress = streetNameAddress;
        this.lotNumberAddress = lotNumberAddress;
        this.time = time;
        this.info = info;
        this.homepages = homepages == null ? new ArrayList<>() : homepages;
    }

    public void addHomepage(Homepage homepage) {
        this.homepages.add(homepage);
        homepage.setShop(this);
    }
}
