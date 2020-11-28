package fpt.java.finalproject.models;

public class AdminQuery {
    private String name;
    private Integer categoryId, brandId, shopId, productId;

    public AdminQuery(String name, Integer categoryId, Integer brandId, Integer shopId, Integer productId) {
        this.name = name;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.shopId = shopId;
        this.productId = productId;
    }

    public String generateSQLQuery() {
        if (!isEmptyQuery()) {
            return "group by id asc \\";
        }
        String str = "WHERE ";
        boolean isFirst = true;
        if (!this.name.equals("")) {
            str = solveSQLVariable(str, "name", this.name, isFirst);
            isFirst = false;
        }

        if (this.categoryId != 0) {
            str = solveSQLVariable(str, "category_id", this.categoryId + "", isFirst);
            isFirst = false;
        }

        if (this.brandId != 0) {
            str = solveSQLVariable(str, "brand_id", this.brandId + "", isFirst);
            isFirst = false;
        }

        if (this.shopId != 0) {
            str = solveSQLVariable(str, "shop_id", this.shopId + "", isFirst);
            isFirst = false;
        }

        if (this.productId != 0) {
            str = solveSQLVariable(str, "product_id", this.productId + "", isFirst);
        }

        return str;
    }

    public String solveSQLVariable(String str, String varName, String var, boolean isFirst) {
        if (!isFirst) {
            str += " AND ";
        }

        str += varName;

        if (varName.equals("name")) {
            str += " like %";
        } else {
            str += " = ";
        }

        str += var;
        
        return str;
    }

    public boolean isEmptyQuery() {
        if (!this.name.equals("") || this.categoryId != 0 || this.brandId != 0 || this.shopId != 0
                || this.productId != 0) {
            return false;
        }
        return true;
    }

    public String generateResponseQuery(String str) {
        boolean isFirst = true;

        if (!this.name.equals("")) {
            str = solveResponseVariable(str, "name", this.name, isFirst);
            isFirst = false;
        }

        if (this.categoryId != 0) {
            str = solveResponseVariable(str, "categoryId", this.categoryId + "", isFirst);
            isFirst = false;
        }

        if (this.brandId != 0) {
            str = solveResponseVariable(str, "brandId", this.brandId + "", isFirst);
            isFirst = false;
        }

        if (this.shopId != 0) {
            str = solveResponseVariable(str, "shopId", this.shopId + "", isFirst);
            isFirst = false;
        }

        if (this.productId != 0) {
            str = solveResponseVariable(str, "productId", this.productId + "", isFirst);
        }

        return str;
    }

    public String solveResponseVariable(String str, String varName, String var, boolean isFirst) {
        if (isFirst) {
            str += "?";
        } else {
            str += "&";
        }
        str = str + "?" + varName + "=" + var;
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

}
