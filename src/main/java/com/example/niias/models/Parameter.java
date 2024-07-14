package com.example.niias.models;


import jakarta.persistence.*;


@Entity
@Table(name = "parameters")
public class Parameter {

    private Long id;
    private String name;
    private String type;
    private Double fixedCost;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "fixedCost")
    public Double getFixedCost() {
        return fixedCost;
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

    public void setFixedCost(Double fixedCost) {
        this.fixedCost = fixedCost;
    }
}