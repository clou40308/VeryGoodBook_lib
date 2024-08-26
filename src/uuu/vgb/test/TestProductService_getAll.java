package uuu.vgb.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Product;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.ProductService;

public class TestProductService_getAll {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		
		try {
//			List<Product> list=pService .getAllProducts();
			List<Product> list=pService .getAllProductsByKeyword("asus");
			System.out.println(list);
		} catch (VGBException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(),e); 
		}
	}

}
