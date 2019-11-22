package com.toshiba.assetmgmtapp.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Builder
public class Asset implements Serializable, Comparable<Asset> {

    private long id;

    private double price;

    private String name;

    @Override
    public int compareTo(Asset asset) {
        return (int) (this.id - asset.id);
    }
}