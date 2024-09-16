package uuu.vgb.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Product;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.ProductService;

public class TestProductService_查詢最新上架產品 {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		
		try {
			List<Product> list=pService .getLatestProducts();
			System.out.println(list);
		} catch (VGBException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(),e); 
		}
	}

}
