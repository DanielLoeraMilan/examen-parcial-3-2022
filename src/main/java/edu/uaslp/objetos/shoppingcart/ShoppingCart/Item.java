package edu.uaslp.objetos.shoppingcart.ShoppingCart;

import java.math.BigDecimal;

public class Item {
    private String code;
    private String providerCode;
    private int quantity;
    private BigDecimal unitCost;

    public Item(String itemCode, String providerCode, BigDecimal unitCost, int quantity) {
        this.code = itemCode;
        this.providerCode = providerCode;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public Item(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
}
