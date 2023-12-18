package com.cart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "size")
public class Size implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    @Column(name = "avlb_size")
    private String avlbSize;

    @Column(name = "pid")
    private Integer pid;

}
