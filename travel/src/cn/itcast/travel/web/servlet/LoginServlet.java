package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.DataSourceUtils;





@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession();
				
				//1、获得用户名和密码
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				// 获得输入的验证码
				String checkCode_client = (String) request.getParameter("checkCode");
				System.out.println("checkCode_client:"+checkCode_client);
				// 获得生成的验证码
				String CHECKCODE_SERVER = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
				
				System.out.println("CHECKCODE_SERVER:"+CHECKCODE_SERVER);
				//2、从数据库中验证该用户名和密码是否正确
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				
				String sql = "select * from tab_user where username=? and password=?";
				User user = null;
				try {
					user = runner.query(sql, new BeanHandler<User>(User.class), username,password);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		
				
				//判断用户是否登录成功 user是否是null
				if(user!=null&&checkCode_client.equals(CHECKCODE_SERVER)){
					//request.setAttribute("loginInfo", "您的验证码不正确！！！");
					//将user对象存到session中
					session.setAttribute("user", user);
					
					//登录成功
					//***************判断用户是否勾选了自动登录*****************
					String autoLogin = request.getParameter("autoLogin");
					if("autoLogin".equals(autoLogin)){
						//要自动登录
						//创建存储用户名的cookie
						Cookie cookie_username = new Cookie("cookie_username",user.getUsername());
						cookie_username.setMaxAge(10*60);
						//创建存储密码的cookie
						Cookie cookie_password = new Cookie("cookie_password",user.getPassword());
						cookie_password.setMaxAge(10*60);

						response.addCookie(cookie_username);
						response.addCookie(cookie_password);
						//用户登录成功
						request.getRequestDispatcher("/routeList").forward(request, response);
					}
					else {
						//用户登录失败
							
							request.getRequestDispatcher("loginfail.jsp").forward(request, response);
					}
					
				}else{
					request.setAttribute("loginInfo", "您的账号或验证码不正确！！！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				
				
	}	
				
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
