package pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class infoPage {
	
	@SerializedName("page")
	private String ipage;
	
	@SerializedName("per_page")
	private String iper_page;
	
	@SerializedName("total")
	private String itotal;
	
	@SerializedName("total_pages")
	private String itotal_pages;
	
	@SerializedName("data")
	private List<Employees> idata;
	
	@SerializedName("support")
	private String isupport;


	public infoPage() {
		
	}
	
	public String getPage() {
		return ipage;
	}

	public void setPage(String page) {
		this.ipage = page;
	}

	public String getPer_page() {
		return iper_page;
	}

	public void setPer_page(String per_page) {
		this.iper_page = per_page;
	}

	public String getTotal() {
		return itotal;
	}

	public void setTotal(String total) {
		this.itotal = total;
	}
	
	public String getItotal_pages() {
		return itotal_pages;
	}

	public void setItotal_pages(String itotal_pages) {
		this.itotal_pages = itotal_pages;
	}

	public List<Employees> getData() {
		return idata;
	}

	public void setData(List<Employees> data) {
		this.idata = data;
	}
	
	

}
