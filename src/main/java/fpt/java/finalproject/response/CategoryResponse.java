package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.models.Category;

public class CategoryResponse extends Response {
    
    private Category category;
    private List<Category> categoryList;
    private boolean isEdit;

    public CategoryResponse() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

	@Override
	public String toString() {
		return "CategoryResponse [eList=" + categoryList + ", category=" + category + ", isEdit=" + isEdit + "]";
	}

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

}
