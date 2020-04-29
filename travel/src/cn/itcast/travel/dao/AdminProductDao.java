package cn.itcast.travel.dao;

import java.sql.SQLException;

import cn.itcast.travel.domain.Permission;
import cn.itcast.travel.domain.Product;
import cn.itcast.travel.domain.Role;
import cn.itcast.travel.domain.User;

public interface AdminProductDao {
	//新建产品
	public void addProduct(Product product) throws SQLException;
	//新建角色
	public void addRole(Role role) throws SQLException;
	//新建资源权限
	public void addPermission(Permission permission) throws SQLException;
	//新建用户
	public void addUser(User user) throws SQLException;
	//删除产品
	public void deleteProduct(String id) throws SQLException; 
}
