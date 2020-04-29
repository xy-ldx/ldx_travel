package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.DataSourceUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {

	@Override
	public List<Route> findAllRoute() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from tab_route like ? ranem";
		List<Route> routeList=runner.query(sql, new BeanListHandler<Route>(Route.class));
		return routeList;
	}

	@Override
	public int getTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from tab_route";
		Long query = (Long) runner.query(sql, new ScalarHandler());
		return query.intValue();	
	}

	@Override
	public List<Route> findRouteListForPageBean(int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from tab_route limit ?,?";
		return runner.query(sql, new BeanListHandler<Route>(Route.class), index,currentCount);
	}

	@Override
	public List<Object> findByWord(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from tab_route where rname like ? limit 0,5";
		List<Object> nameList = runner.query(sql, new ColumnListHandler("rname"), "%"+word+"%");
		return nameList;
	}
  

   
}
