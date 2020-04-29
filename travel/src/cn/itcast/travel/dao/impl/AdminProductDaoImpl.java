package cn.itcast.travel.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.travel.dao.AdminProductDao;
import cn.itcast.travel.domain.Permission;
import cn.itcast.travel.domain.Product;
import cn.itcast.travel.domain.Role;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.DataSourceUtils;

public class AdminProductDaoImpl implements AdminProductDao {

	@Override
	public void addProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?)";
		runner.update(sql, product.getId(),product.getProductNum(),product.getProductName(),product.getDepartureTime(),product.getCityName(),product.getProductPrice(),product.getProductDesc(),product.getProductStatus());
		
	}

	@Override
	public void addRole(Role role) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into role values(?,?,?)";
		runner.update(sql, role.getId(),role.getRoleName(),role.getRoleDesc());
	}

	@Override
	public void addPermission(Permission permission) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into permission values(?,?,?)";
		runner.update(sql, permission.getId(),permission.getPermissionName(),permission.getUrl());
		
	}

	@Override
	public void addUser(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into users values(?,?,?,?,?,?)";
		runner.update(sql, user.getUid(),user.getEmail(),user.getUsername(),user.getPassword(),user.getPhoneNum(),user.getStatus());
		
	}

	@Override
	public void deleteProduct(String id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where id=?";
		runner.update(sql, id);
		
	}

}
