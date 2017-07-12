package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Product;
import utils.DataSourceUtils;

public class ProductDao {

	/**
	 * 查询所有商品
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =  "select * from product";
		
		return qr.query(sql, new BeanListHandler<>(Product.class));
	}
/**
 * 添加商品
 * @param p
 * @throws SQLException 
 */
	public void addProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?)";
		
		qr.update(sql,p.getPid(),p.getPname(),p.getMarket_price(),
				p.getShop_price(),p.getDate(),p.getPdesc());
	}
	/**
	 * 通过商品id获取商品
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public Product getProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from product where pid=?";
		return qr.query(sql, new BeanHandler<>(Product.class),pid);
	}
	/**
	 * 修改商品信息
	 * @param p 商品信息
	 * @throws SQLException 
	 */
	public void updateProductById(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "update product set pname = ?,market_price = ?,shop_price = ?,pdesc=? where pid = ?";
		qr.update(sql,p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdesc(),p.getPid());
	}
	/**
	 * 删除商品
	 * @param pid 商品id
	 * @throws SQLException 
	 */
	public void deleteProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "delete from product where pid =?";
		qr.update(sql,pid);
		
	}

}
