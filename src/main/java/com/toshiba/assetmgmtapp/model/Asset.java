package com.toshiba.assetmgmtapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Target;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Builder
@Entity
@Table(name="assets")
public class Asset implements Serializable, Comparable<Asset> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "asset_price", nullable = false)
    private double price;

    private String name;

    @Override
    public int compareTo(Asset asset) {
        return (int) (this.id - asset.id);
    }
}