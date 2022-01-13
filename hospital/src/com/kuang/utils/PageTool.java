package com.kuang.utils;
/**
 * 分页工具类
 * /*
		分析分页查询
		1.总记录数totalCount  从数据库中查询
		2.每页显示几条（页容量）pageSize 指定一个默认值
		3.总页数：totalPages  totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1
		4.当前页码:currentPage 从页面中获取
		5.上一页prePage currentPage-1
		6.下一页nextPage currentPage+1
		7.每页首条记录的起始值startIndex   (currentPage-1)*pageSize
*/

public class PageTool {
	public PageTool(int totalCount,String currentPage) {
		this.totalCount=totalCount;
		initCurrentPage(currentPage);
		this.pageSize=3;//给固定的值
		initTotalPages();
		initPrePage();
		initNextPage();
		initStartIndex();
	}
	//当前页码的初始化
	public void initCurrentPage(String currentPage) {
		if(currentPage==null) {
			this.currentPage=1;
		}else {
			this.currentPage=Integer.valueOf(currentPage);
		}
	}
	//总页数初始化
	public void initTotalPages() {
		this.totalPages=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	}
	//初始化上一页
	public void initPrePage() {
		if(this.currentPage==1) {
			this.prePage=1;
		}else {
			this.prePage=this.currentPage-1;
		}
	}
	//初始化下一页
	public void initNextPage() {
		if(this.currentPage==this.totalPages) {
			this.nextPage=this.totalPages;
		}else {
			this.nextPage=this.currentPage+1;
		}
	}
	//每页首条记录的起始下标
	public void initStartIndex() {
		this.startIndex=(currentPage-1)*pageSize;
	}
	private int totalCount;//总记录数
	private int pageSize;//页容量
	private int totalPages;//总页数
	private int currentPage;//当前页码
	private int prePage;//上一页
	private int nextPage;//下一页
	private int startIndex;//每一页首条记录的起始下标
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
}
