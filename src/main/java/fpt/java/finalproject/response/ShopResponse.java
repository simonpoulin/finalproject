package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.models.Shop;

public class ShopResponse extends Response {
    
    private Shop shop;
    private List<Shop> shopList;
    private boolean isEdit;

    public ShopResponse() {
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

	@Override
	public String toString() {
		return "ShopResponse [eList=" + shopList + ", shop=" + shop + ", isEdit=" + isEdit + "]";
	}

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

}
