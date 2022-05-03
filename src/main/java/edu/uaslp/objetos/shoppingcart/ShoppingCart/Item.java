package edu.uaslp.objetos.shoppingcart.ShoppingCart;

import java.math.BigDecimal;

public class Item {
    private String itemCode;
    private String ProviderCode;
    private int Quantity;
    private BigDecimal UnitCost;

    public Item(String itemCode, String providerCode, BigDecimal unitCost, int quantity) {
        this.itemCode = itemCode;
        ProviderCode = providerCode;
        Quantity = quantity;
        UnitCost = unitCost;
    }

    public Item(){

    }

    public String getCode() {
        return itemCode;
    }

    public void setCode(String code) {
        itemCode = code;
    }

    public String getProviderCode() {
        return ProviderCode;
    }

    public void setProviderCode(String providerCode) {
        ProviderCode = providerCode;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public BigDecimal getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        UnitCost = unitCost;
    }
}
