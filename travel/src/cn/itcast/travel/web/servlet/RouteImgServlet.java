package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;


public class RouteImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RouteImgServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受参数
		String id= request.getParameter("id");
				
		int rid=Integer.parseInt(id);
		RouteService service=new RouteServiceImpl();
		
		List<RouteImg> routeImgList=null;
		try {
			routeImgList=service.findByRid(rid);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		Route rroute=null;
		try {
			 rroute=service.FindByRid(rid);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		request.setAttribute("rroute", rroute);
		
		request.setAttribute("routeImgList", routeImgList);
		request.getRequestDispatcher("/route_detail.jsp").forward(request, response);
	
		/*Gson gson = new Gson();
		String json = gson.toJson(routeImgList);
		System.out.println(json);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);
		//
		Gson gson1 = new Gson();
		String json1 = gson1.toJson(rroute);
		System.out.println(json1);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json1);*/
	}
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
