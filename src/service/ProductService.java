package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Product;

public class ProductService {
	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return list
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		return new ProductDao().findAll();
	}
/**
 * �����Ʒ
 * @param p
 * @throws SQLException 
 */
	public void addProduct(Product p) throws SQLException {
		new ProductDao().addProduct(p);
	}
	/**
	 * ͨ����Ʒid��ȡ��Ʒ
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public Product getProductById(String pid) throws SQLException {
		
		return new ProductDao().getProductById(pid);
	}
	/**
	 * �޸���Ʒ
	 * @param p ��Ʒ��Ϣ
	 * @throws SQLException 
	 */
	public void updateProduct(Product p) throws SQLException {
		new ProductDao().updateProductById(p);
	}
	/**
	 * ͨ��pidɾ����Ʒ
	 * @param pid ��Ʒ
	 * @throws SQLException 
	 */
	public void deleteProductById(String pid) throws SQLException {
		new ProductDao().deleteProductById(pid);
	}
	/**
	 * ɾ�������Ʒ
	 * @param ids
	 * @throws SQLException 
	 */
	public void deleteManyProduct(String[] ids) throws SQLException {
		ProductDao pdao = new ProductDao();
		for(String pid:ids){
			pdao.deleteProductById(pid);
		}
	}

}
