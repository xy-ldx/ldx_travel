package cn.itcast.travel.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.travel.domain.Orders;
import cn.itcast.travel.domain.OrdersAndProduct;
import cn.itcast.travel.domain.Permission;
import cn.itcast.travel.domain.Product;
import cn.itcast.travel.domain.Role;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.domain.UserInfo;

public interface AdminUserService {
	public List<UserInfo> readUserInfo() throws SQLException;
	
	public List<Role> readRole() throws SQLException;
	
	public List<Permission> readPermission() throws SQLException;
	
	public List<Product> raedProduct() throws SQLException;
	
	public List<OrdersAndProduct>  readOrders() throws SQLException;
	
	//通过id查询用户详情
	public User findUserById(String uid) throws SQLException;
}
