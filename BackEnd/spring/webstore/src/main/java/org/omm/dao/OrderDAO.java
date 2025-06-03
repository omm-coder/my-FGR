package org.omm.dao;

import org.omm.model.Order;

public interface OrderDAO  {

    long saveOrder(Order order);

}
