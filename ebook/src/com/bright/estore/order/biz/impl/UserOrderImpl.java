package com.bright.estore.order.biz.impl;

import com.bright.estore.order.biz.IUserOrderServiec;
import com.bright.estore.order.dao.IUserOrderDAO;
import com.bright.estore.order.dao.impl.UserOrderSqlServerDAOImpl;
import com.bright.estore.order.model.OrderModel;

public class UserOrderImpl implements IUserOrderServiec {

	public boolean saveOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		IUserOrderDAO order = new UserOrderSqlServerDAOImpl();
		return order.saveOrder(orderModel);
	}

}
