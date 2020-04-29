package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.travel.service.AdminProductService;
import cn.itcast.travel.service.impl.AdminProductServiceImpl;


public class DelProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DelProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		AdminProductService service=new AdminProductServiceImpl();
		
		try {
			service.deleteProduct(id);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		request.getRequestDispatcher("/readProduct").forward(request, response);
	}
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
