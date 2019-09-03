package br.com.hirai.teste;


import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.hirai.teste.Model.Product;
import br.com.hirai.teste.Model.ProductItem;
import br.com.hirai.teste.Model.Receipt;

/**
 * @andrehirai
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	//Output 1
    	String[] products = new String[] {"book","music CD","chocolate bar"}; 
    	BigDecimal[] prices = new BigDecimal[] {new BigDecimal(12.49), new BigDecimal(14.99)
    											,new BigDecimal(0.85)};
    	int[] quantitys = new int[] {1,1,1};
    	
    	ArrayList<Product> productsList1 = createProducts(products);
    	
    	ArrayList<ProductItem> productItemList1 = populateProductItem(productsList1,prices,quantitys);
    	
    	generateReceipt(productItemList1);
    	
    	//Output 2
    	String[] products2 = new String[] {"imported box of chocolates","imported bottle of perfume"}; 
    	BigDecimal[] prices2 = new BigDecimal[] {new BigDecimal(10.00), new BigDecimal(47.50)};
    	int[] quantitys2 = new int[] {1,1};
    	
    	ArrayList<Product> productsList2 = createProducts(products2);
    	
    	ArrayList<ProductItem> productItemList2 = populateProductItem(productsList2,prices2,quantitys2);
    	
    	generateReceipt(productItemList2);
    	
    	
    	
    }

	private static void generateReceipt(ArrayList<ProductItem> productItemList) {
		Receipt rec = new Receipt();
		for (ProductItem productItem : productItemList) {
			rec.addItem(productItem);
		}
		
		System.out.println(rec.toString());
	}

	private static ArrayList<ProductItem> populateProductItem(ArrayList<Product> productsList, BigDecimal[] prices,int[] quantitys) {
		ArrayList<ProductItem> productsItemList = new ArrayList<ProductItem>(); 
		for(int i=0;i<productsList.size();i++) {
			ProductItem productItem = new ProductItem(productsList.get(i),quantitys[i],prices[i]);
			productsItemList.add(productItem);
		}
		return productsItemList;
	}

	private static ArrayList<Product> createProducts(String[] products) {
		ArrayList<Product> productsList = new ArrayList<Product>(); 
		
		for(int i=0;i<products.length;i++) {
			Product product = new Product(products[i]);
			productsList.add(product);
		}
		
		return productsList;
	}
}
