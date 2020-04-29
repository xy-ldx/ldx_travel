package cn.itcast.travel.dao;

import java.sql.SQLException;
import java.util.List;



import cn.itcast.travel.domain.Route;



public interface RouteDao {
	//查找所有地方
	public List<Route> findAllRoute() throws SQLException;
	//查找地方总数目
	public int getTotalCount() throws SQLException;
	
	public List<Route> findRouteListForPageBean(int index, int currentCount) throws SQLException;
   
	public List<Object> findByWord(String word) throws SQLException;
}
