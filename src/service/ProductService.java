package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Product;
import domain.pageBean;

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
	/**
	 * 多条件查询
	 * @param name 商品名称
	 * @param kw 关键词
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findProductByCondition(String name, String kw) throws SQLException {
		
		return new ProductDao().findProductByCondition(name,kw);
	}
	/**
	 * 分页查询
	 * @param currPage 第几页
	 * @param pageSize 每页显示的条数
	 * @return pageBean
	 * @throws SQLException 
	 */
	public pageBean<Product> showProductsByPage(int currPage, int pageSize) throws SQLException {
		//查询当前页数据limit（当前页-1）*每页显示条数，每页显示条数；
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findProductByCondition(currPage,pageSize);
		//查询总条数
		int totalCount = dao.getCount();
		
		return new pageBean<>(list,currPage,pageSize,totalCount);
		
	}

}
