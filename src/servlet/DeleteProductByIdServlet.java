package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;

/**
 * ͨ����Ʒidɾ����Ʒ
 */
public class DeleteProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ��Ʒid
		String pid = request.getParameter("pid");
		
		//2.����service�������ɾ������
		try {
			new ProductService().deleteProductById(pid);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "��Ʒɾ��ʧ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return ;
		}
		
		//3.�ض���FindAllServlet
		response.sendRedirect(request.getContextPath()+"/findAll");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
