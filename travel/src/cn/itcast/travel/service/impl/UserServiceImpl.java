package cn.itcast.travel.service.impl;

import java.sql.SQLException;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;



public class UserServiceImpl implements UserService {
	UserDao dao=new UserDaoImpl();
	
	//注册
	@Override
	public int Register(User user) throws SQLException {
		
		return dao.Register(user);
	}
	//注册判断是否成功
	@Override
	public boolean regist(User user) throws SQLException {
		int row = 0;
		try {
			row = dao.Register(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return row>0?true:false;
	}
	
	
	@Override
	public boolean checkUsername(String username) throws SQLException {
		Long isExist = 0L;
		try {
			isExist = dao.checkUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExist>0?true:false;

	}

	
	
	
	@Override
	public void active(String code) throws SQLException {
		dao.active(code);
	}

	

	

	
   


    
}
