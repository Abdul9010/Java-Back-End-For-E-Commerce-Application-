package com.ecommerce.Digicart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Digicart.Dao.ProductDao;
import com.ecommerce.Digicart.Model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public boolean add(Product product) {
		
		return productDao.add(product);
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return productDao.list();
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return productDao.update(product);
	}

	@Override
	public boolean delete(Product delete) {
		
		return productDao.delete(delete);
	}

}
