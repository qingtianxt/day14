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
	 * ��ѯ������Ʒ
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =  "select * from product";
		
		return qr.query(sql, new BeanListHandler<>(Product.class));
	}
/**
 * �����Ʒ
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
	 * ͨ����Ʒid��ȡ��Ʒ
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
	 * �޸���Ʒ��Ϣ
	 * @param p ��Ʒ��Ϣ
	 * @throws SQLException 
	 */
	public void updateProductById(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "update product set pname = ?,market_price = ?,shop_price = ?,pdesc=? where pid = ?";
		qr.update(sql,p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdesc(),p.getPid());
	}
	/**
	 * ɾ����Ʒ
	 * @param pid ��Ʒid
	 * @throws SQLException 
	 */
	public void deleteProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "delete from product where pid =?";
		qr.update(sql,pid);
		
	}

}
