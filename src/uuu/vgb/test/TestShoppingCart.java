package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.ShoppingCart;
import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;

public class TestShoppingCart {

	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		ProductService pService = new ProductService();

		try {
			Customer member = cService.login("F128546809", "a123456");
			ShoppingCart cart = new ShoppingCart();
			cart.setMember(member);

			// 第一個測試
			{
				String productId = "1"; // 必要
				String cpuName = null;
				String sizeName = null;
				int quantity = 1; // 必要

				Product p = pService.getProductById(productId);
				Size size = null;

				cart.addToCart(p, cpuName, size, quantity);
//				System.out.println(cart);
			}

		} catch (VGBException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		} catch (Exception e) {
			Logger.getLogger("").log(Level.SEVERE, "發生系統錯誤: " + e.getMessage(), e);
		}

	}
}
