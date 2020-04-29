package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.travel.domain.UserInfo;
import cn.itcast.travel.service.AdminUserService;
import cn.itcast.travel.service.impl.AdminUserServiceImpl;


public class ReadAdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReadAdminUserServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		
		AdminUserService service=new AdminUserServiceImpl();
		 List<UserInfo>	userList=null;
		 
		 try {
			userList=service.readUserInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 request.setAttribute("userList", userList);
		
		 request.getRequestDispatcher("/pages/user-list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
