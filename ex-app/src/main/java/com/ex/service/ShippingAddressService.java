package com.ex.service;

import com.ex.entity.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {
    public Integer insertShippingAddress(ShippingAddress shippingAddress);
    public List<ShippingAddress> selectShippingAddress(Long registUserId);
}
