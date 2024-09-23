package uuu.vgb.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.ProductService;

public class TestProductService_用分類查詢產品清單_尺寸 {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		
		try {
			List<Size> list=pService .getProductSizeByIdAndCpuName("8","Ultra 7");
			System.out.println(list);
		} catch (VGBException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(),e); 
		}
	}

}
