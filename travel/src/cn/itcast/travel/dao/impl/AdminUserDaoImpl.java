package cn.itcast.travel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



import cn.itcast.travel.dao.AdminUserDao;

import cn.itcast.travel.domain.OrdersAndProduct;
import cn.itcast.travel.domain.Permission;
import cn.itcast.travel.domain.Product;
import cn.itcast.travel.domain.Role;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.domain.UserInfo;
import cn.itcast.travel.util.DataSourceUtils;

public class AdminUserDaoImpl implements AdminUserDao {
     
	@Override
	public List<UserInfo> readUserInfo() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from users ";
		List<UserInfo> userList = runner.query(sql, new BeanListHandler<UserInfo>(UserInfo.class));
		return userList;	
	}

	@Override
	public List<Role> readRole() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from role ";
		List<Role> roleList = runner.query(sql, new BeanListHandler<Role>(Role.class));
		return roleList;	
	}

	@Override
	public List<Permission> readPermission() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from permission ";
		List<Permission> permisssionList = runner.query(sql, new BeanListHandler<Permission>(Permission.class));
		return permisssionList;	
	}

	@Override
	public List<Product> raedProduct() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product ";
		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;	
	}

	@Override
	public List<OrdersAndProduct> readOrders() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders a,product b where a.productId=b.id ";
		List<OrdersAndProduct> orderList = runner.query(sql, new BeanListHandler<OrdersAndProduct>(OrdersAndProduct.class));
		return orderList;	
	}

	@Override
	public User findUserById(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from users where id=?";
		User user = runner.query(sql, new BeanHandler<User>(User.class),uid);
		return user;
		
	}

}
