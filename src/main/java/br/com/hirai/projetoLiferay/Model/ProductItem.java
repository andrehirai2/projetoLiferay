package br.com.hirai.projetoLiferay.Model;

import java.math.BigDecimal;

public class ProductItem {
	private Product product;
	private int qty;
	private BigDecimal price;
	private BigDecimal tax;
	
	
	
	
	public ProductItem(Product product, int qty, BigDecimal price) {
		super();
		this.product = product;
		this.qty = qty;
		this.setPrice(price);
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
		return this.price.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price.multiply(new BigDecimal(this.qty));
		this.setTax();
		this.price = this.price.add(this.tax);
	}
	
	public BigDecimal getTax() {
		return tax;
	}
	
	public void setTax() {
		this.tax = Tax.calculateTax(this.product, this.price);
	}
	
	
}
