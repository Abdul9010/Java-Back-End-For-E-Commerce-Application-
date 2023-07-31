package com.ecommerce.Digicart.Dao;

import java.util.List;

import com.ecommerce.Digicart.Model.Product;

public interface ProductDao {
	public boolean add(Product product);
	public List<Product> list();
	public boolean update(Product product);
	public boolean delete(Product delete);
}
