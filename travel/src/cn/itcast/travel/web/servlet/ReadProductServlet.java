package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.travel.domain.Product;
import cn.itcast.travel.service.AdminUserService;
import cn.itcast.travel.service.impl.AdminUserServiceImpl;


public class ReadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AdminUserService service=new AdminUserServiceImpl();
		List<Product> productList=null;
		try {
			productList=service.raedProduct();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("pages/product-list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
