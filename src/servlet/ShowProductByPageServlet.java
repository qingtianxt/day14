package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import domain.pageBean;
import service.ProductService;

/**
 * ��ҳչʾ����
 */
public class ShowProductByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.���ñ���
		
		//1.��ȡ�ڼ�ҳ
		int currPage = Integer.parseInt(request.getParameter("currPage"));
//		�̶�ÿҳ��ʾ������
		int pageSize =3;
		//2������service ��ɷ�ҳ��ѯ������ֵ��pagebean
		pageBean<Product> bean =null;
		try {
			bean = new ProductService().showProductsByPage(currPage,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3��pagebean����request���У�����ת��product����page.jps
		request.setAttribute("pb", bean);
		request.getRequestDispatcher("/product_page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
