package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.AdminUserService;
import cn.itcast.travel.service.impl.AdminUserServiceImpl;


public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserDetailsServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String uid=request.getParameter("id");
		AdminUserService service=new AdminUserServiceImpl();
		User user=null;
		try {
			user=service.findUserById(uid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		session.setAttribute("user", user);
		request.getRequestDispatcher("/pages/user-edit.jsp").forward(request, response);
	}
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
