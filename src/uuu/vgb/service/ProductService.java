package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBDataInvalidException;
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
	
	public Size getTheSize(String productId,String cpuName,String sizeName)throws VGBException{
		if(productId == null || productId.length()==0) {
			throw new IllegalArgumentException("查詢[指定產品-CPU-尺寸]時，productId必須要有值");
		}
		
		if(sizeName == null || sizeName.length()==0) {
			throw new IllegalArgumentException("查詢[指定產品-CPU-尺寸]時，sizeName必須要有值");
		}
		
		if(cpuName==null) {
			cpuName="";
		}
		
		Size theSize =null;
		List<Size> list =this.getProductSizeByIdAndCpuName(productId,cpuName);
		
		if(list !=null &&list.size()>0) {
			for(int i = 0; i< list.size();i++) {
				Size size = list.get(i);
				if(sizeName.equals(size.getSizeName())) {
					theSize = size;
					break;
				}
			}
		}
		
		if(theSize == null) {
			String errMsg= String.format("找不到指定的規格: %s-%s-%s ",productId,cpuName,sizeName);
			throw new VGBDataInvalidException(errMsg);
		}
		
		return theSize;
	}
} 
