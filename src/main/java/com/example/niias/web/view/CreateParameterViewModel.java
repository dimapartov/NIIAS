package com.example.niias.web.view;
import java.math.BigDecimal;

public class CreateParameterViewModel {

    private Long id;
    private String name;
    private String type;
    private BigDecimal fixedPrice;


    public CreateParameterViewModel() {
    }

    public CreateParameterViewModel(String name, String type, BigDecimal fixedPrice) {
        this.name = name;
        this.type = type;
        this.fixedPrice = fixedPrice;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

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