package br.com.hirai.teste.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
	private BigDecimal totalTax;
	private BigDecimal totalPrice;
	private List<ProductItem> list;
	
	public Receipt() {
		this.list = new ArrayList<ProductItem>();
	}
	
	public void addItem(ProductItem pi) {
		this.list.add(pi);
		this.setTotalPrice(this.list);
		this.setTotalTax(this.list);
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(List<ProductItem> list) {
		this.totalTax = Tax.calculateTotalTax(list);
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	private void setTotalPrice(List<ProductItem> list) {
		this.totalPrice = Tax.calculateTotalPrice(list);
	}

	public List<ProductItem> getList() {
		return list;
	}
	
	
	
}
