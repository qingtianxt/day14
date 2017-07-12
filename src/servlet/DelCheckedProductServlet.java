package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;

/**
 *ɾ�������Ʒ
 */
public class DelCheckedProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ��Ʒid
		String []ids = request.getParameterValues("pid");
		
		//2.����service�������ɾ�����
		
		try {
			new ProductService().deleteManyProduct(ids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3.ҳ���ض���
		response.sendRedirect(request.getContextPath()+"/findAll");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
