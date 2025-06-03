package org.omm.service.impl;

import org.omm.dao.OrderDAO;
import org.omm.model.Order;
import org.omm.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceIMPL implements OrderService {


    private final OrderDAO orderDAO;

    public OrderServiceIMPL(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public Long saveOrder(Order order) {
        return orderDAO.saveOrder(order);
    }
}
