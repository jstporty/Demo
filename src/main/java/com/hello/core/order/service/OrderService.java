package com.hello.core.order.service;

import com.hello.core.order.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
