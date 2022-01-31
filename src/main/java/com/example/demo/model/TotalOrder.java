package com.example.demo.model;

import java.util.List;

public class TotalOrder {
	public List<DinnerMenu> menu;
	public String total;
	public String applicable;
	public String discTotal;
	
	public TotalOrder() {
		
	}
	
	
	
	public TotalOrder(List<DinnerMenu> menu, String total, String applicable, String discTotal) {
		super();
		this.menu = menu;
		this.total = total;
		this.applicable = applicable;
		this.discTotal = discTotal;
	}


	

	public List<DinnerMenu> getMenu() {
		return menu;
	}



	public void setMenu(List<DinnerMenu> menu) {
		this.menu = menu;
	}



	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getApplicable() {
		return applicable;
	}

	public void setApplicable(String applicable) {
		this.applicable = applicable;
	}

	public String getDiscTotal() {
		return discTotal;
	}

	public void setDiscTotal(String discTotal) {
		this.discTotal = discTotal;
	}
	
	

}
