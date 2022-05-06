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

    public void addItem(Item item){
        /*if(item.getProviderCode()!=null || item.getProviderCode()!=""){
            if(shoppingCartList.size()>0 || shoppingCartList.size()<5){
                shoppingCartList.add(item);
            }
        }else{
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }*/

        if(item.getCode() == null){
            throw new InvalidDataException("Null or empty string not allowed for item code");
        }

        if(item.getProviderCode().isEmpty()){
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }

        if(item.getUnitCost().compareTo(BigDecimal.ZERO)<0){
            throw new InvalidDataException("Cost must be greater than zero");
        }

        if(item.getQuantity() < 1 || item.getQuantity() > 5){
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }

        for(Item existentItem: shoppingCartList){
            if(existentItem.getCode().equals(item.getCode()) && existentItem.getUnitCost().compareTo(item.getUnitCost()) == 0){
                existentItem.setQuantity(existentItem.getQuantity() + item.getQuantity());
                return;
            }
        }

        shoppingCartList.add(item);

    }

    public int getItemsCount() {
        int count = 0;
        for(Item item: shoppingCartList){
            count += item.getQuantity();
        }

        return count;
    }

    public List<Item> getItems() {
        return shoppingCartList;
    }

    public void removeItem(String itemCode) {
        for(Item item : shoppingCartList){
            if(item.getCode().equals(itemCode)){
                item.setQuantity(item.getQuantity() - 1);

                if(item.getQuantity() == 0){
                    shoppingCartList.remove(item);
                }

                return;
            }
        }
    }
}
