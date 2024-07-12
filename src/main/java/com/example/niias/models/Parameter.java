package com.example.niias.models;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "parameters")
public class Parameter {

    private Long id;
    private String name;
    private String type;
    private BigDecimal fixedPrice;


    protected Parameter() {}

    public Parameter(String name, String type, BigDecimal fixedPrice) {
        this.name = name;
        this.type = type;
        this.fixedPrice = fixedPrice;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    @Column(name = "fixedPrice")
    public BigDecimal getFixedPrice() {
        return fixedPrice;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFixedPrice(BigDecimal fixedPrice) {
        this.fixedPrice = fixedPrice;
    }
}