package com.ecommerce.Digicart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.Digicart.Dao.UserDao;
import com.ecommerce.Digicart.Model.UserModel;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	
	@Transactional
	public boolean register(UserModel user) {
		
		return userDao.register(user);
	}
	@Override
	public boolean login(UserModel user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
