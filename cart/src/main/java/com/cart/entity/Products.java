package com.cart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column(name = "pdesc", nullable = false)
    private String pdesc;

    @Column(name = "pname", nullable = false)
    private String pname;

    @OneToMany
    @JoinColumn(referencedColumnName = "pid")
    private List<Brands> brands;

    @OneToMany
    @JoinColumn(referencedColumnName = "pid")
    private List<Colors> colors;

    @OneToMany
    @JoinColumn(referencedColumnName = "pid")
    private List<Size> sizes;


}
