package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.models.ShopItem;

public class UserHomeResponse extends UserResponse {

    private List<ShopItem> mostViewList, mostSellList;
    private List<Shop> mostViewShop;

    public List<ShopItem> getMostViewList() {
        return mostViewList;
    }

    public void setMostViewList(List<ShopItem> mostViewList) {
        this.mostViewList = mostViewList;
    }

    public List<Shop> getMostViewShop() {
        return mostViewShop;
    }

    public void setMostViewShop(List<Shop> mostViewShop) {
        this.mostViewShop = mostViewShop;
    }

    public List<ShopItem> getMostSellList() {
        return mostSellList;
    }

    public void setMostSellList(List<ShopItem> mostSellList) {
        this.mostSellList = mostSellList;
    }

}
