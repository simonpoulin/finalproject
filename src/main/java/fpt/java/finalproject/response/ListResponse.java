package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.utils.Config;

public class ListResponse<E> extends Response {

    private List<E> list, pagedList;
    private Integer page, totalPage, limit;

    public ListResponse() {
    }

    public void generateResponse() {
        generateResponse(this.list);
    }

    public void generateResponse(List<E> list) {
        generateResponse(list, this.limit);
    }

    public void generateResponse(List<E> list, int limit) {
        generateResponse(list, limit, this.page);
    }

    public void generateResponse(List<E> list, int limit, int page) {

        // Set limit
        if (limit != 0) {
            this.limit = limit;
        } else {
            limit = this.limit = new Config().PAGE_LIMIT;
        }

        // Set list
        if (list != null) {
            this.list = list;
        } else {
            list = this.list;
        }

        // Set totalPage
        this.totalPage = Math.floorDiv(list.size(), limit);

        // Set pagedList
        this.pagedList = list.subList(page * limit, (page + 1) * limit);

    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<E> getPagedList() {
        return pagedList;
    }

    public void setPagedList(List<E> pagedList) {
        this.pagedList = pagedList;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
