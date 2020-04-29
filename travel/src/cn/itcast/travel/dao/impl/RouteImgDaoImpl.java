package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.DataSourceUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteImgDaoImpl implements RouteImgDao {

    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());


    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ? ";
        return template.query(sql,new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);
    }


	@Override
	public Route FindByRid(int rid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from tab_route where rid = ? ";
		Route rroute = runner.query(sql, new BeanHandler< Route>( Route.class),rid);
		return rroute;
	}


	@Override
	public List<Route> findByRname(String rname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<String> list = new ArrayList<String>();
		String sql = "select * from tab_route where 1=1";
		if(rname!=null&&!rname.trim().equals("")){
			sql+=" and rname like ? order by price";
			list.add("%"+rname.trim()+"%");
		}
		List<Route> place = runner.query(sql, new BeanListHandler<Route>(Route.class) , list.toArray());
		return  place;
		
	}
		      
}
