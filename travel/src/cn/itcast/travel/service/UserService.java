package cn.itcast.travel.service;

import java.sql.SQLException;

import cn.itcast.travel.domain.User;





public interface UserService {
	//注册
	public int Register(User user) throws SQLException;
	//判断注册是否成功
	public boolean regist(User user) throws SQLException;
	//校验用户名
	public boolean checkUsername(String username) throws SQLException;
	

	//激活
	public void active(String code) throws SQLException;
			
		
	
}
