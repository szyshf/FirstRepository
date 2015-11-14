package com.bright.estore.order.biz;

import com.bright.estore.order.model.OrderModel;

public interface IUserOrderServiec {
  
	 public boolean saveOrder(OrderModel orderModel);
}
