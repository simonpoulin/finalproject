package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.models.Brand;

public class BrandResponse extends Response {
    
    private Brand brand;
    private List<Brand> brandList;
    private boolean isEdit;

    public BrandResponse() {
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

	@Override
	public String toString() {
		return "BrandResponse [eList=" + brandList + ", brand=" + brand + ", isEdit=" + isEdit + "]";
	}

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

}
