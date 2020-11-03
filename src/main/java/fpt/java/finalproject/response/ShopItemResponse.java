package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.models.ShopItem;

public class ShopItemResponse extends Response {
    
    private ShopItem shopItem;
    private List<ShopItem> shopItemList;
    private boolean isEdit;

    public ShopItemResponse() {
    }

    public ShopItem getShopItem() {
        return shopItem;
    }

    public void setShopItem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

	@Override
	public String toString() {
		return "ShopItemResponse [eList=" + shopItemList + ", shopItem=" + shopItem + ", isEdit=" + isEdit + "]";
	}

    public List<ShopItem> getShopItemList() {
        return shopItemList;
    }

    public void setShopItemList(List<ShopItem> shopItemList) {
        this.shopItemList = shopItemList;
    }

}
