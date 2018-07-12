package com.ex.dao;

import com.ex.entity.ShippingAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShippingAddressDao {
    public Integer insertShippingAddress(ShippingAddress shippingAddress);
    public List<ShippingAddress> selectShippingAddress(Long registUserId);
}
