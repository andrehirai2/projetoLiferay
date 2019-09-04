package br.com.hirai.teste.Model;
import java.util.List;
import java.util.Arrays;

public class Product {
	private String name;
	private boolean isImported;
	private boolean productExempt;
	private static final String[] productsTypeExempt = {"book","chocolate","chocolates","pills","chocolates"};
	
	public Product(String name) {
		this.productExempt = false;
		this.name = name;
		this.checkProductImported(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isImported() {
		return isImported;
	}
	
	public boolean getProductExempt() {
		return productExempt;
	}
	public void setProductType(boolean productExempt) {
		this.productExempt = productExempt;
	}
	
	private void checkProductImported(String name) {
		this.isImported = name.contains("imported");
		this.productExempt = this.checkProductType(name);
	}
	
	private Boolean checkProductType(String name) {
		   boolean bResult=false;

		   List<String> list = Arrays.asList(Product.productsTypeExempt);
		   for (String word: list ) {
		       boolean bFound = name.contains(word);
		       if (bFound) {bResult=bFound; break;}
		   }
		   return bResult;
	}
	
	
}
