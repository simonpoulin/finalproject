package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.utils.Config;

public class AdminListResponse<E> extends AdminResponse {

    private List<E> pagedList;
    private Integer page, totalPage, limit;
    private String pagingStr;
    private boolean isEmpty;

    public AdminListResponse() {
        super();
    }

    public void generateResponse(List<E> list, int limit, int page, String pagingStr) throws Exception {

        // Check list size
        if (list.isEmpty()) {
            this.isEmpty = true;
            throw new Exception("blank list");
        }

        // Set limit
        if (limit > 0) {
            this.limit = limit;
        } else {
            limit = this.limit = new Config().PAGE_LIMIT;
        }

        // Set page
        if (page < 0) {
            this.page = page = 0;
        } else {
            this.page = page;
        }

        // Set pagingStr
        if (pagingStr.contains("?")) {
            pagingStr += "&";
        } else {
            pagingStr += "?";
        }
        this.pagingStr = pagingStr + "page=";

        // Set totalPage
        this.totalPage = (int) Math.ceil(((double) list.size()) / ((double) limit));
        if (page >= totalPage) {
            throw new Exception("out of pages");
        }

        // Set pagedList
        int fromIndex = page * limit;
        int toIndex = 0;
        if (page == totalPage - 1) {
            toIndex = list.size();
        } else {
            toIndex = fromIndex + limit;
        }

        this.pagedList = list.subList(fromIndex, toIndex);

        
        
    }

    public List<E> getPagedList() {
        return pagedList;
    }

    public void setPagedList(List<E> pagedList) {
        this.pagedList = pagedList;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getPagingStr() {
        return pagingStr;
    }

    public void setPagingStr(String pagingStr) {
        this.pagingStr = pagingStr;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

}
