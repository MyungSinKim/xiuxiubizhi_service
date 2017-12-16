package com.xiaour.xiuxiubizhi.entity;


public class PageDto {
	private  int totalPage;//总页数
	private  int startNum;//开始记录数
	private  int endNum=18;//结束记录数
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int pageNum) {
		if(pageNum==1) {
			this.startNum=0;
		}else {
			this.startNum = pageNum*endNum-endNum-1;
		}
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
}
