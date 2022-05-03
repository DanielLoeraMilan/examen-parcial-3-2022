package edu.uaslp.objetos.shoppingcart.ShoppingCart;

import edu.uaslp.objetos.shoppingcart.Exceptions.EmptyShoppingCartException;
import edu.uaslp.objetos.shoppingcart.Exceptions.InvalidDataException;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    private BigDecimal totalCost;
    List<Item> shoppingCartList = new LinkedList<>();


    public boolean isEmpty() {
        return shoppingCartList.size() == 0;
    }

    public BigDecimal getTotalCost(){
        BigDecimal totalCost = BigDecimal.ZERO;

        for(Item item: shoppingCartList){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        if (shoppingCartList.size()==0){
            throw new EmptyShoppingCartException();
        }

        return totalCost;
    }

    public void addItem(Item item) {
        if(item.getProviderCode()!=null || item.getProviderCode()!=""){
            if(shoppingCartList.size()>0 || shoppingCartList.size()<5){
                shoppingCartList.add(item);
            }
        }else{
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }

    }


    public int getItemsCount() {
        return shoppingCartList.size();
    }

    public List<Item> getItems() {
        return shoppingCartList;
    }

    public void removeItem(String itemCode2) {
    }
}
