package cn.itcast.travel.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;

/**
 * 线路Service
 */
public interface RouteService {
		//查找所有地方
		public List<Route> findAllRoute() throws SQLException;
		//查找地方总数目
		public int getTotalCount() throws SQLException;
		
		public List<Route> findRouteListForPageBean(int index, int currentCount) throws SQLException;
		//分页操作
		public PageBean findPageBean(int currentPage, int currentCount) throws SQLException; 

		public List<RouteImg> findByRid(int rid) throws SQLException;

		public Route FindByRid(int rid) throws SQLException;
		
		public List<Route> findByRname(String rname) throws SQLException;
		
		public List<Object> findByWord(String word) throws SQLException;
}
