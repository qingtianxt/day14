package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductService;

/**
 * ͨ����Ʒid��ȡ��Ʒ
 */
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.���ñ���
		
		//1.��ȡ��Ʒpid
		String pid = request.getParameter("pid");
		
		//2������service ͨ��id��ȡ��Ʒ������ֵProduct
		Product p= null;
		try {
			p = new ProductService().getProductById(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.��product����request���У�����ת����edit.jsp
		
		request.setAttribute("bean", p);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
