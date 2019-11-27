package com.toshiba.assetmgmtapp.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @Range(min = 55_000, max = 80_000, message = "Asset price cannot exceed 80K")
    private double price;

    @NotBlank(message = "Asset name cannot be blank")
    private String name;

    @Override
    public int compareTo(Asset asset) {
        return (int) (this.id - asset.id);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}