package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Product;
import service.ProductService;

/**
 * �޸���Ʒ
 */
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.���ñ���
		request.setCharacterEncoding("utf-8");
		//1.��װ����
		Product p = new Product();
		try{
			
			BeanUtils.populate(p, request.getParameterMap());
			//2.����service ��ɸ���
			new ProductService().updateProduct(p);
			//3.�ض���FIndAllServlet
			response.sendRedirect(request.getContextPath()+"/findAll");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "�޸���Ʒ����");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
