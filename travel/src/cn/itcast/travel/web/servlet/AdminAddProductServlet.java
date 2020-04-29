package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;



import cn.itcast.travel.domain.Product;
import cn.itcast.travel.service.AdminProductService;
import cn.itcast.travel.service.impl.AdminProductServiceImpl;

import cn.itcast.travel.util.DateUtils;


public class AdminAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminAddProductServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String,String[]> properties=request.getParameterMap();
		Product product=new Product();
		try {
			
			//自己指定一个类型转换器（将String转成Date）
			ConvertUtils.register(new Converter() {
				@Override
				public Object convert(Class clazz, Object value) {
					//将string转成date
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					java.util.Date parse =null;
					java.sql.Date parsesql=null;
					try {
						parse = format.parse(value.toString());
						parsesql= new java.sql.Date(parse.getTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					System.out.println(parse);
					return parsesql;
				}
			}, Date.class);
			
			BeanUtils.populate(product, properties);
		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		//1）、private String pid;
		product.setId(DateUtils.getUUID());;
//		product.setProductStatus(0);
		
		AdminProductService service=new AdminProductServiceImpl();
		try {
			service.addProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/readProduct");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
