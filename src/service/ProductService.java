package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Product;

public class ProductService {
	/**
	 * 查询所有商品
	 * 
	 * @return list
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		return new ProductDao().findAll();
	}
/**
 * 添加商品
 * @param p
 * @throws SQLException 
 */
	public void addProduct(Product p) throws SQLException {
		new ProductDao().addProduct(p);
	}
	/**
	 * 通过商品id获取商品
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public Product getProductById(String pid) throws SQLException {
		
		return new ProductDao().getProductById(pid);
	}
	/**
	 * 修改商品
	 * @param p 商品信息
	 * @throws SQLException 
	 */
	public void updateProduct(Product p) throws SQLException {
		new ProductDao().updateProductById(p);
	}
	/**
	 * 通过pid删除商品
	 * @param pid 商品
	 * @throws SQLException 
	 */
	public void deleteProductById(String pid) throws SQLException {
		new ProductDao().deleteProductById(pid);
	}
	/**
	 * 删除多个商品
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
