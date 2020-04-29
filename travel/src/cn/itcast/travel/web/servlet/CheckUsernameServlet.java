package cn.itcast.travel.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;


public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckUsernameServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得要校验的用户名
		String username  =request.getParameter("username");
		
		//传递username到service
		UserService service=new UserServiceImpl();
		boolean isExist=false;
		try {
			isExist=service.checkUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("{\"isExist\":"+isExist+"}");	
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
