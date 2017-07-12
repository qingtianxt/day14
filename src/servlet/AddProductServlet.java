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
 *	�����Ʒ
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.���ñ���
		request.setCharacterEncoding("utf-8");
		
		//��չ ���ƻ���
		//0.1 ��ȡsession�����ƺ��ύ����������
		String r_lingpai = request.getParameter("r_lingpai");
		String s_lingpai = (String) request.getSession().getAttribute("s_lingpai");
		
		//0.2�Ƴ�session�е�����
		request.getSession().removeAttribute("s_lingpai");
	
		//0.3�Ƚ���������
		
		if(s_lingpai==null||!r_lingpai.equals(s_lingpai)){
			request.setAttribute("msg", "��Ʒ�ѱ���");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return ;
		}
		
		//1����װ����

		Product p  = new Product();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			
			//1.1 ����pid
			p.setPid(UUIDUtils.getId());
			//1.2 ����ʱ��
			p.setDate(new Date());
			//2.����service�����Ӳ���
			new ProductService().addProduct(p);
			//3.ҳ����ת
			//��������ת��
			request.getRequestDispatcher("/findAll").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "�����Ʒʧ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
