package br.com.hirai.teste.Model;

import java.math.BigDecimal;
import java.util.List;

public class Tax {
	public static BigDecimal calculateTax(Product product, BigDecimal price) {
		if(product.isImported()) {
			return price.multiply(new BigDecimal(1.05));
		}
		if(product.getProductExempt()) {
			return price.multiply(new BigDecimal(1.05));
		}
		return price;
	}
	
	public static BigDecimal calculateTotalPrice(List<ProductItem> list) {
		BigDecimal total = new BigDecimal(0);
		
		for (ProductItem productItem : list) {
			total.add(productItem.getPrice());
		}
		return total;
	}
	
	public static BigDecimal calculateTotalTax(List<ProductItem> list) {
		BigDecimal total = new BigDecimal(0);
		
		for (ProductItem productItem : list) {
			total.add(productItem.getTax());
		}
		return total;
		
	}
}
