package com.lyh.autoex;

public class DataFlow {

    DefaultFilter filter;
    public DataFlow setFilter(Filter filter){
        this.filter= (DefaultFilter) filter;
        return this;
    }


    public DataFlow getInput(){
        System.out.println("Get Input!!!");
        return this;
    }

    public DataFlow filterData(){
        System.out.println("filter Data!!!");
        filter.filter();
        return this;
    }

}
