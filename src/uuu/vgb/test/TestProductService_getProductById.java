package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Product;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.ProductService;

public class TestProductService_getProductById {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		
		try {
			Product  p =pService.getProductById("2");
			System.out.println(p);
		} catch (VGBException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(),e); 
		}
	}

}
