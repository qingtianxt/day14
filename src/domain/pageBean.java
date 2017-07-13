package domain;

import java.util.List;

public class pageBean<T> {
	private List<T> list;//当前页内容  查询
	private int currentPage;//当前页码  传递
	private int pageSize;//每页显示的条数  固定
	private int totalCount;//总条数  查询
	private int totalPage;//总页数   计算
	public List<T> getList() {
		return list;
	}
	
	public pageBean() {
		
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return (int) (Math.ceil(totalCount*1.0/pageSize));
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public pageBean(List<T> list, int currentPage, int pageSize, int totalCount) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	
}
