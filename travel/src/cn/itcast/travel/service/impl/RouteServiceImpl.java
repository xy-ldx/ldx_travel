package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.service.RouteService;

import java.sql.SQLException;
import java.util.List;


public class RouteServiceImpl implements RouteService {
	  RouteDao dao =new RouteDaoImpl();
	  RouteImgDao Dao=new  RouteImgDaoImpl();
	  
	@Override
	public List<Route> findAllRoute() throws SQLException {
		
		return dao.findAllRoute();
	}

	@Override
	public int getTotalCount() throws SQLException {
		
		return dao.getTotalCount();
	}

	@Override
	public List<Route> findRouteListForPageBean(int index, int currentCount) throws SQLException {
		
		return dao.findRouteListForPageBean(index, currentCount);
	}

	@Override
	public PageBean findPageBean(int currentPage, int currentCount) throws SQLException {
				//目的：就是想办法封装一个PageBean 并返回
				PageBean pageBean = new PageBean();
				//1、当前页private int currentPage;
						pageBean.setCurrentPage(currentPage);
						//2、当前页显示的条数private int currentCount;
						pageBean.setCurrentCount(currentCount);
						//3、总条数private int totalCount;
						int totalCount = dao.getTotalCount();
						pageBean.setTotalCount(totalCount);
						//4、总页数private int totalPage;
						/*
						 * 总条数		当前页显示的条数	总页数
						 * 10		4				3
						 * 11		4				3
						 * 12		4				3
						 * 13		4				4
						 * 
						 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
						 * 
						 */
						int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
						pageBean.setTotalPage(totalPage);
						//5、每页显示的数据private List<T> productList = new ArrayList<T>();
						/*
						 * 页数与limit起始索引的关系
						 * 例如 每页显示4条
						 * 页数		其实索引		每页显示条数
						 * 1		0			4
						 * 2		4			4
						 * 3		8			4
						 * 4		12			4
						 * 
						 * 索引index = (当前页数-1)*每页显示的条数
						 * 
						 */
						int index = (currentPage-1)*currentCount;
						
						List<Route> routeList = dao.findRouteListForPageBean(index, currentCount);
						pageBean.setRouteList(routeList);
						
						return pageBean;
	}

	@Override
	public List<RouteImg> findByRid(int rid) throws SQLException {
		
		return Dao.findByRid(rid);
	}

	@Override
	public Route FindByRid(int rid) throws SQLException {
		
		return Dao.FindByRid(rid);
	}

	@Override
	public List<Route> findByRname(String rname) throws SQLException {
		
		return Dao.findByRname(rname);
	}

	@Override
	public List<Object> findByWord(String word) throws SQLException {
		
		return dao.findByWord(word);
	}

	

    
}
