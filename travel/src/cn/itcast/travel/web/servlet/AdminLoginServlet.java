package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.travel.domain.User;
import cn.itcast.travel.domain.UserInfo;
import cn.itcast.travel.util.DataSourceUtils;


public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//1、获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2、从数据库中验证该用户名和密码是否正确
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select * from users where username=? and password=?";
		UserInfo admin = null;
		try {
			admin = runner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		username=admin.getUsername();
		password=admin.getPassword();
		System.out.println(username);
		System.out.println(password);
		
		//判断用户是否登录成功 admin是否是null
		if(admin!=null){
			
			//将admin对象存到session中
			session.setAttribute("admin", admin);
		    
			//登录成功
			//***************判断用户是否勾选了自动登录*****************
			String autoLogin = request.getParameter("autoLogin");
			if("autoLogin".equals(autoLogin)){
				//要自动登录
				//创建存储用户名的cookie
				Cookie cookie_username = new Cookie("cookie_username",admin.getUsername());
				cookie_username.setMaxAge(10*60);
				//创建存储密码的cookie
				Cookie cookie_password = new Cookie("cookie_password",admin.getPassword());
				cookie_password.setMaxAge(10*60);

				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
				//用户登录成功
				request.getRequestDispatcher("pages/main.jsp").forward(request, response);
			}else {
				//用户登录失败
				response.setContentType("text/html; charset=UTF-8");
			response.setHeader("refresh", "5;url=pages/login.jsp");
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
