package com.ex.vo;

import com.ex.entity.ShareProduct;

import java.io.Serializable;
import java.util.List;

public class ShareProductVo extends ShareProduct implements Serializable {
    List<ShareOrderVo>  shareOrderVos;

    public List<ShareOrderVo> getShareOrderVos() {
        return shareOrderVos;
    }

    public void setShareOrderVos(List<ShareOrderVo> shareOrderVos) {
        this.shareOrderVos = shareOrderVos;
    }
}
