package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.travel.domain.Role;
import cn.itcast.travel.service.AdminUserService;
import cn.itcast.travel.service.impl.AdminUserServiceImpl;


public class ReadRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadRoleServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AdminUserService service=new AdminUserServiceImpl();
		List<Role> roleList=null;
		 try {
			roleList=service.readRole();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 request.setAttribute("roleList",roleList);
		 request.getRequestDispatcher("pages/role-list.jsp").forward(request, response);
		 
	}
	
     
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
