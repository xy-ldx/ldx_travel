package cn.itcast.travel.service.impl;

import java.sql.SQLException;

import cn.itcast.travel.dao.AdminProductDao;
import cn.itcast.travel.dao.impl.AdminProductDaoImpl;
import cn.itcast.travel.domain.Permission;
import cn.itcast.travel.domain.Product;
import cn.itcast.travel.domain.Role;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.AdminProductService;

public class AdminProductServiceImpl implements AdminProductService{
     AdminProductDao dao =new    AdminProductDaoImpl();
     
	@Override
	public void addProduct(Product product) throws SQLException {	
		dao.addProduct(product);
	}

	@Override
	public void addRole(Role role) throws SQLException {
		dao.addRole(role);
		
	}

	@Override
	public void addPermission(Permission permission) throws SQLException {
		dao.addPermission(permission);
	}

	@Override
	public void addUser(User user) throws SQLException {
		dao.addUser(user);
		
	}

	@Override
	public void deleteProduct(String id) throws SQLException {
		dao.deleteProduct(id);
		
	}
}
