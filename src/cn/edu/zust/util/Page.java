package cn.edu.zust.util;

public class Page {
	private int pageIndex;
	private int pageSize = 10;
	private int totalPage;
	private long totalCount;
	
	public Page() {
	}

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		totalPage = (int) totalCount / pageSize
				+ (totalCount % pageSize == 0 ? 0 : 1);
	}

	public int getFirstResult() {
		return (pageIndex - 1) * pageSize;
	}

	public boolean getHasPreviours() {
		return pageIndex > 1;
	}

	public boolean getHasNext() {
		return pageIndex < totalPage;
	}
}
