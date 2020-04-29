package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;


public class RnameSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RnameSearchServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、收集表单数据
		Map<String, String[]> properties = request.getParameterMap();
		//2、将散装的查询数据封装到一个VO实体中
		Route route = new Route();
		
		try {
			BeanUtils.populate(route, properties);
		} catch (IllegalAccessException | InvocationTargetException e1) {
		
			e1.printStackTrace();
		}
		
		List<Route> place=null;
		String rname=route.getRname();
		//3、将实体传递给service层
		RouteService service = new RouteServiceImpl();
		try {
			 place=service.findByRname(rname);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("place", place);
		request.getRequestDispatcher("/route_list.jsp").forward(request, response);
	
		/*Gson gson = new Gson();
		String json = gson.toJson(place);
		System.out.println(json);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
