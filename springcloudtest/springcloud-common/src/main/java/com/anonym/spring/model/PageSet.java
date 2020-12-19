package com.anonym.spring.model;

import java.io.Serializable;

/**
 * @author 王培忠
 * @date 2020/4/17 15:15
 * @email 805705089@qq.com
 * @Description
 * @Reason ADDREASON
 * @since JDK 1.8
 */
public class PageSet implements Serializable {

    private static final long serialVersionUID = 2859671973806541640L;
    private Object DataRows;
    private String RetCode;
    private String RetVal;
    /*总条数*/
    private int AllCount;
    /*总页数*/
    private int PageCount;
    /*当前第几页*/
    private int PageCurrent;
    /*每页显示的总条数*/
    private int PageSize;

    public Object getDataRows() {
        return DataRows;
    }

    public void setDataRows(Object dataRows) {
        DataRows = dataRows;
    }

    public String getRetCode() {
        return RetCode;
    }

    public void setRetCode(String retCode) {
        RetCode = retCode;
    }

    public String getRetVal() {
        return RetVal;
    }

    public void setRetVal(String retVal) {
        RetVal = retVal;
    }

    public int getAllCount() {
        return AllCount;
    }

    public void setAllCount(int allCount) {
        AllCount = allCount;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public int getPageCurrent() {
        return PageCurrent;
    }

    public void setPageCurrent(int PageCurrent) {
        this.PageCurrent = PageCurrent;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int rowCount) {
        PageSize = rowCount;
    }



}
