package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;

import java.sql.SQLException;
import java.util.List;

public interface RouteImgDao {

    /**
     * 根据route的id查询图片
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
    
    /**
     * 根据route的id查询路线介绍
     * @param rid
     * @return
     * @throws SQLException 
     */
    public Route FindByRid(int rid) throws SQLException;
    
    public List<Route> findByRname(String rname) throws SQLException;
}
