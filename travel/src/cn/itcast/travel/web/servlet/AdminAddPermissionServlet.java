package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.travel.domain.Permission;

import cn.itcast.travel.service.AdminProductService;
import cn.itcast.travel.service.impl.AdminProductServiceImpl;
import cn.itcast.travel.util.DateUtils;


public class AdminAddPermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminAddPermissionServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//1、获取数据
		Map<String, String[]> properties = request.getParameterMap();
		//2、封装数据
		Permission permission=new Permission();
		
		try {
			BeanUtils.populate(permission, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
		
			e.printStackTrace();
		}
		
		permission.setId(DateUtils.getUUID());
		
		AdminProductService service=new AdminProductServiceImpl();
		
		try {
			service.addPermission(permission);;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/readPermission");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
