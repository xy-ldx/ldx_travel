package cn.itcast.travel.dao;

import java.sql.SQLException;

import cn.itcast.travel.domain.User;


public interface UserDao {
	//注册
	public int  Register(User user) throws SQLException;
	//校验用户名
	public Long  checkUsername(String username) throws SQLException;
	
	public void active(String code) throws SQLException;
	
	
}
