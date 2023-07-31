package com.ecommerce.Digicart.Service;

import java.util.List;

import com.ecommerce.Digicart.Model.Product;

public interface ProductService {
	public boolean add(Product product);
	public List<Product> list();
	public boolean update(Product product);
	public boolean delete(Product delete);
}
