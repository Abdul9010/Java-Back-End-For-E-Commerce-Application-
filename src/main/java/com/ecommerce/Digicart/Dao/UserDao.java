package com.ecommerce.Digicart.Dao;

import com.ecommerce.Digicart.Model.UserModel;

public interface UserDao {
	
	public boolean register(UserModel user);
	public boolean login(UserModel user);
}
