package com.ex.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageRequest implements Serializable {

  private int pageNum;
  private int pageSize = 20;

  public int getOffset(){
    return pageNum * pageSize;
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
}