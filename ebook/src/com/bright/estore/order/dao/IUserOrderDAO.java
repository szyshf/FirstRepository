package com.bright.estore.order.dao;

import com.bright.estore.order.model.OrderModel;

public interface IUserOrderDAO {
	public boolean saveOrder(OrderModel orderModel);
}
