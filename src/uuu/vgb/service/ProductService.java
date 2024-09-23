package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBException;

public class ProductService {
	private ProductsDAO dao = new ProductsDAO();

	public List<Product> getAllProducts() throws VGBException {
		return dao.selectAllProducts();
	}

	public List<Product> getAllProductsByKeyword(String keyword) throws VGBException {
		if (keyword == null || keyword.length() == 0) {
			throw new IllegalArgumentException("關鍵字查詢功能keyword不得為null或空字串");
		}
		return dao.selectProductsByKeyword(keyword);
	}

	public List<Product> getProductsByCategory(String category) throws VGBException {
		if (category == null || category.length() == 0) {
			throw new IllegalArgumentException("[分類查詢]category不得為null或空字串");
		}
		return dao.selectProductsByCategory(category);
	}
	
	public List<Product> getLatestProducts() throws VGBException {
		return dao.selectLatestProducts();
	}
	
	public Product getProductById(String id)  throws VGBException {
		if (id == null || id.length() == 0) {
			throw new IllegalArgumentException("[用id查詢產品]id不得為null或空字串");
		}
		return dao.selectProductById(id);
	}
	
	public List<Size> getProductSizeByIdAndCpuName(String productId,String cpuName) throws VGBException{
		if (productId == null || productId.length() == 0) {
			throw new IllegalArgumentException("查詢[指定產品-尺寸]的sizeList時，productId必須要有值");
		}
		return dao.selectProductSizeByIdAndCpuName(productId,cpuName);
	}
} 
