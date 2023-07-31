package com.ecommerce.Digicart.Service;

import com.ecommerce.Digicart.Model.UserModel;

public interface UserService {
	public boolean register(UserModel user);
	public boolean login(UserModel user);
}
