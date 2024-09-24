package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.LoginFailedException;
import uuu.vgb.exception.VGBException;

public class CustomerService {
	private CustomersDAO dao = new CustomersDAO();
	
	public Customer login(String id, String password) throws VGBException {
		if(id==null || id.length()==0 || password==null || password.length()==0) 
			throw new IllegalArgumentException("登入會員必須輸入帳號、密碼");
		
		Customer c = dao.selectById(id);
		if(c!=null && password != null && password.equals(c.getPassword())) {
			//TODO:sendLoginOKEmail(c.getEmail());
			return c;
		}
		
		throw new LoginFailedException("登入失敗，帳號或密碼不正確");
	}	

	public void register(Customer c) throws VGBException{
		if(c==null) throw new IllegalArgumentException("註冊會員時客戶物件不得為null");
		dao.insert(c);
	}
	
	public void update(Customer c) throws VGBException{
		if(c==null) throw new IllegalArgumentException("更新會員時客戶物件不得為null");
		dao.update(c);
	}
}
