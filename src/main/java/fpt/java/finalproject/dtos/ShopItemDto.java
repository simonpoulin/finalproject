package fpt.java.finalproject.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.models.ShopItem;

public class ShopItemDto implements Serializable {

    private Integer id;

    private String title;

    private String des;

    private Float price;

    private Integer quantity;

    private MultipartFile image;

    private String imageName;

    private Integer productId;

    private Integer shopId;

    public ShopItemDto() {
    }

    public ShopItemDto(ShopItem s) {
        this.id = s.getId();
        this.title = s.getTitle();
        this.des = s.getDes();
        this.price = s.getPrice();
        this.quantity = s.getQuantity();
        this.imageName = s.getImage();
        this.productId = s.getProduct().getId();
        this.shopId = s.getShop().getId();
    }

    public ShopItem convertToShopItem() {
        ShopItem s = new ShopItem();
        if (this.id != null && this.id > 0) {
            s.setId(this.id);
        }

        s.setTitle(this.title);
        s.setDes(this.des);
        s.setPrice(this.price);
        s.setImage(this.imageName);

        if (this.productId!= null || this.productId > 0) {
            Product p = new Product();
            p.setId(this.productId);
            s.setProduct(p);
        }

        if (this.shopId != null || this.shopId > 0) {
            Shop sh = new Shop();
            sh.setId(this.shopId);
            s.setShop(sh);
        }

        return s;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
