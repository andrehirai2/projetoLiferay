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
		return this.totalTax.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public void setTotalTax(List<ProductItem> list) {
		this.totalTax = Tax.calculateTotalTax(list);
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private void setTotalPrice(List<ProductItem> list) {
		this.totalPrice = Tax.calculateTotalPrice(list);
	}

	public List<ProductItem> getList() {
		return list;
	}
	
	@Override
	public String toString() {
		String receipt = "Receipt:\n";
		
		for (ProductItem productItem : this.list) {
			receipt += productItem.getQty() + " " + productItem.getProduct().getName() + ": " + productItem.getPrice() + "\n"; 
		}
		
		receipt += "Sales Taxes: " + this.getTotalTax() + "\nTotal: " + this.getTotalPrice();
		
		return receipt;
		
	}
	
}
