package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.models.Product;

public class ProductResponse extends Response {
    
    private Product product;
    private List<Product> productList;
    private boolean isEdit;

    public ProductResponse() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

	@Override
	public String toString() {
		return "ProductResponse [eList=" + productList + ", product=" + product + ", isEdit=" + isEdit + "]";
	}

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
