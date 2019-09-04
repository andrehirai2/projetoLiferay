package br.com.hirai.projetoLiferay.Model;

import java.math.BigDecimal;
import java.util.List;

public class Tax {
	private final static BigDecimal importedRate = new BigDecimal(0.05);
	private final static BigDecimal noExemptedRate = new BigDecimal(0.10);
	private final static BigDecimal fullRate = new BigDecimal(0.15);
	
	public static BigDecimal calculateTax(Product product, BigDecimal price) {
		if(product.isImported() && !product.getProductExempt() ) {
			price = price.multiply(fullRate);
			return roundingFunction(price,new BigDecimal("1"));
			}
		
		if(product.isImported()) {
			price = price.multiply(importedRate);
			return roundingFunction(price,new BigDecimal("0.9"));
		}
		
		if(!product.getProductExempt()) {
			return price.multiply(noExemptedRate);
			
		}
		return new BigDecimal(0);
	}
	
	public static BigDecimal calculateTotalPrice(List<ProductItem> list) {
		BigDecimal total = new BigDecimal(0);
		
		for (ProductItem productItem : list) {
		 total = total.add(productItem.getPrice());
		}
		return total;
	}
	
	public static BigDecimal calculateTotalTax(List<ProductItem> list) {
		BigDecimal total = new BigDecimal(0);
		
		for (ProductItem productItem : list) {
			total = total.add(productItem.getTax());
		}
		return total;	
	}
	
	public static BigDecimal roundingFunction(BigDecimal price, BigDecimal round) {
		return new BigDecimal(price.multiply(new BigDecimal(20))
                .add(round)
                .toBigInteger()).divide(new BigDecimal(20));	
	}
	
	
	
}
