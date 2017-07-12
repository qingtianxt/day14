package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Product;
import service.ProductService;
import utils.UUIDUtils;

/**
 *	添加商品
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		
		//扩展 令牌机制
		//0.1 获取session中令牌和提交过来的令牌
		String r_lingpai = request.getParameter("r_lingpai");
		String s_lingpai = (String) request.getSession().getAttribute("s_lingpai");
		
		//0.2移除session中的令牌
		request.getSession().removeAttribute("s_lingpai");
	
		//0.3比较两个令牌
		
		if(s_lingpai==null||!r_lingpai.equals(s_lingpai)){
			request.setAttribute("msg", "商品已保存");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return ;
		}
		
		//1，封装数据

		Product p  = new Product();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			
			//1.1 设置pid
			p.setPid(UUIDUtils.getId());
			//1.2 设置时间
			p.setDate(new Date());
			//2.调用service完成添加操作
			new ProductService().addProduct(p);
			//3.页面跳转
			//先用请求转发
			request.getRequestDispatcher("/findAll").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "添加商品失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
