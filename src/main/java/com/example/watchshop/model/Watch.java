package com.example.watchshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "watchentity")
public class Watch {
    @Id
    @Column(name="watchid")
    private int watchId;
    @Column(name="watchname")
    private String watchName;
    @Column(name="unitprice")
    private double unitPrice;
    @Column(name="discount")
    private String discount;

}
