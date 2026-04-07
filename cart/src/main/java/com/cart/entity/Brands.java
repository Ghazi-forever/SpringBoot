package com.cart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "brands")
public class Brands implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;

    @Column(name = "bname")
    private String bname;

    @Column(name = "pid")
    private Integer pid;

}
