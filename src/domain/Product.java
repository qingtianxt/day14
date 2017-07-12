package domain;
//2017.7.11 商品实体类 
//注释：快捷键：alt+s  +   r  +  alt+a  快速创建set get函数
//alt+s   +  alt+a  快速创建构造函数
import java.util.Date;

public class Product {
/**
 * 	`pid` varchar (96),
			`pname` varchar (150),
			`market_price` double ,
			`shop_price` double ,
			`pimage` varchar (600),
			`pdate` date ,
			`pdesc` varchar (765)
 */
	private String pid;
	private String pname;
	private double market_price;
	
	private double shop_price;
	private String pimage;
	private Date date;
	private String pdesc;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public double getShop_price() {
		return shop_price;
	}
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	
	
}
