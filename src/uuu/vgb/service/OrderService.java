package uuu.vgb.service;

import uuu.vgb.entity.Order;
import uuu.vgb.exception.VGBException;

public class OrderService {
	private OrderDAO dao = new OrderDAO();

	public void checkOut(Order order) throws VGBException {
		if (order == null)
			throw new IllegalArgumentException("結帳時，訂單物件不得為null");
		dao.insert(order);
	}
}
