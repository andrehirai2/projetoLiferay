package br.com.hirai.teste.Model;

import java.math.BigDecimal;

public class ProductItem {
	private Product product;
	private int qty;
	private BigDecimal price;
	private BigDecimal tax;
	
	public ProductItem() {
		this.tax = new BigDecimal(0);
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price.multiply(new BigDecimal(this.qty));
	}
	public BigDecimal getTax() {
		return tax;
	}
	
	public void setTax(BigDecimal tax) {
		this.tax = Tax.calculateTax(this.product, tax);
	}
	
	
}
