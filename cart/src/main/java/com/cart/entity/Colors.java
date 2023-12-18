package com.cart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "colors")
public class Colors implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Column(name = "colours")
    private String colours;

    @Column(name = "pid")
    private Integer pid;

}
