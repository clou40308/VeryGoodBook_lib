package uuu.vgb.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;



import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.PaymentType;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.ShippingType;
import uuu.vgb.entity.ShoppingCart;
import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;

public class TestOrder {

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
				//System.out.println(cart);
			}
			
			{
				String productId = "8"; // 必要
				String cpuName = "Ultra 5";
				String sizeName = "14";
				int quantity = 1; // 必要

				Product p = pService.getProductById(productId);
				Size size = null;

				if(p.getSizeCount()>0 && sizeName != null) {
					size = pService.getTheSize(productId,cpuName,sizeName); //TODO:
				}
				
				cart.addToCart(p, cpuName, size, quantity);
				//System.out.println(cart);
			}
			
			{
				String productId = "8"; // 必要
				String cpuName = "Ultra 7";
				String sizeName = "14";
				int quantity = 1; // 必要

				Product p = pService.getProductById(productId);
				Size size = null;

				if(p.getSizeCount()>0 && sizeName != null) {
					size = pService.getTheSize(productId,cpuName,sizeName); //TODO:
				}
				
				cart.addToCart(p, cpuName, size, quantity);
				//System.out.println(cart);
			}
			
			{
				String productId = "9"; // 必要
				String cpuName = null;
				String sizeName = "14";
				int quantity = 1; // 必要

				Product p = pService.getProductById(productId);
				Size size = null;

				if(p.getSizeCount()>0 && sizeName != null) {
					size = pService.getTheSize(productId,cpuName,sizeName); //TODO:
				}
				
				cart.addToCart(p, cpuName, size, quantity);
				System.out.println(cart);
			}
			
			String shippingType ="HOME";
			String paymentType ="ATM";
			
			String name =member.getName();
			String email =member.getEmail();
			String phone =member.getPhone();
			String shippingAdress = member.getAddress();
			
			ShippingType shType =ShippingType.valueOf(shippingType);
			PaymentType pType=PaymentType.valueOf(paymentType);
			
			
			//建立訂單
			Order order = new Order();
			order.setMember(cart.getMember());
			order.setCreatdDate(LocalDate.now());
			order.setCreatedTime(LocalTime.now());
			
			order.setShippingType(shType);
			order.setShippingFee(shType.getFee());

			order.setPaymentType(pType);
			order.setPaymentfee(pType.getFee());
			
			order.setRecipientName(name);
			order.setRecipientPhone(phone);
			order.setRecipientEmail(email);
			order.setShippingAddress(shippingAdress);
			order.add(cart);
			
			//oService.checkOut(order);
			System.out.println(order);
		} catch(VGBDataInvalidException e){
			System.err.println(e);
		} catch (VGBException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		} catch (Exception e) {
			Logger.getLogger("").log(Level.SEVERE, "發生系統錯誤: " + e.getMessage(), e);
		}

	}
}
