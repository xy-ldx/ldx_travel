package cn.itcast.travel.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.travel.dao.AdminUserDao;
import cn.itcast.travel.dao.impl.AdminUserDaoImpl;
import cn.itcast.travel.domain.Orders;
import cn.itcast.travel.domain.OrdersAndProduct;
import cn.itcast.travel.domain.Permission;
import cn.itcast.travel.domain.Product;
import cn.itcast.travel.domain.Role;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.domain.UserInfo;
import cn.itcast.travel.service.AdminUserService;

public class AdminUserServiceImpl implements AdminUserService{
	AdminUserDao dao=new AdminUserDaoImpl();

	@Override
	public List<UserInfo> readUserInfo() throws SQLException {
		
		return dao.readUserInfo();
	}

	@Override
	public List<Role> readRole() throws SQLException {
		
		return dao.readRole();
	}

	@Override
	public List<Permission> readPermission() throws SQLException {
	
		return dao.readPermission();
	}

	@Override
	public List<Product> raedProduct() throws SQLException {
		
		return dao.raedProduct();
	}

	@Override
	public List<OrdersAndProduct> readOrders() throws SQLException {
		
		return dao.readOrders();
	}

	@Override
	public User findUserById(String uid) throws SQLException {
		
		return dao.findUserById(uid);
	}

}
