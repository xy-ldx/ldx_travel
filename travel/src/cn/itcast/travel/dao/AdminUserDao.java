package cn.itcast.travel.dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.travel.domain.Orders;
import cn.itcast.travel.domain.OrdersAndProduct;
import cn.itcast.travel.domain.Permission;
import cn.itcast.travel.domain.Product;
import cn.itcast.travel.domain.Role;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.domain.UserInfo;



public interface AdminUserDao {
	//读取用户管理
	public List<UserInfo> readUserInfo() throws SQLException;
	//读取角色管理
	public List<Role> readRole() throws SQLException;
	//读取权限管理
	public List<Permission> readPermission() throws SQLException;
	//读取产品管理
	public List<Product> raedProduct() throws SQLException;
	//读取订单管理
	public List<OrdersAndProduct>  readOrders() throws SQLException;
	
	//通过id查询用户详情
	public User findUserById(String uid) throws SQLException;
}
