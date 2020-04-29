package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import net.sf.json.JSONArray;


public class SearchWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchWordServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得关键字
		String word=request.getParameter("word");
		
		
		//查询关键字的所有旅游信息
		RouteService service=new RouteServiceImpl();
		List<Object> nameList=null;
		try {
			nameList=service.findByWord(word);
			System.out.println(nameList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		//使用json的转换工具将对象或集合转成json格式的字符串
//		JSONArray fromObject=JSONArray.fromObject(name);
//		String string=fromObject.toString();
//		System.out.println(string);
		
		
		 Gson gson = new Gson();
	     String json = gson.toJson(nameList);
	     System.out.println(json);
	     response.setContentType("text/html;charset=UTF-8");
	     
	     response.getWriter().write(json);
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
