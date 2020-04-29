package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;





@WebServlet("/routeList")
public class RouteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RouteListServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//准备所有动漫的数据----List<Anime>
//		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		String sql ="select * from anime";
//		List<Anime> animeList =null;
//		try {
//			animeList=runner.query(sql, new BeanListHandler<Anime>(Anime.class));
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//		
//		//将动漫的集合准备好
//		//将数据存到request域 转发给yonghu3.jsp进行显示
//		request.setAttribute("animeList", animeList);
//		request.getRequestDispatcher("yonghu3.jsp").forward(request, response);
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String current=request.getParameter("currentPage");
		
	   System.out.println("currentPage:"+current);
		
			
		 
	//传递请求到service层
		RouteService service = new RouteServiceImpl(); 

		//模拟当前是第一页
		String currentPageStr =request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage=Integer.parseInt(currentPageStr);
		//认为每页显示50条
		int currentCount=60;

		PageBean<Route> pageBean=null;
		try {
			pageBean=service.findPageBean(currentPage, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
		
		session.setAttribute("pageBean", pageBean); 
		
	request.getRequestDispatcher("/myfavorite.jsp").forward(request, response);
		
		/*Gson gson = new Gson();
		String json = gson.toJson(pageBean);
		System.out.println(json);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
