package cn.itcast.travel.service;

import java.sql.SQLException;

import cn.itcast.travel.domain.Permission;
import cn.itcast.travel.domain.Product;
import cn.itcast.travel.domain.Role;
import cn.itcast.travel.domain.User;

public interface AdminProductService {
	public void addProduct(Product product) throws SQLException;
	
	public void addRole(Role role) throws SQLException;
	
	public void addPermission(Permission permission) throws SQLException;
	
	public void addUser(User user) throws SQLException;
	
	public void deleteProduct(String id) throws SQLException; 
}
