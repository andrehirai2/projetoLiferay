package br.com.hirai.teste;



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
    	
    	printInputs();
    	
    	//Output 1
    	String[] products = new String[] {"book","music CD","chocolate bar"}; 
    	BigDecimal[] prices = new BigDecimal[] {new BigDecimal(12.49), new BigDecimal(14.99)
    											,new BigDecimal(0.85)};
    	int[] quantitys = new int[] {1,1,1};
    	
    	ArrayList<Product> productsList1 = createProducts(products);
    	
    	ArrayList<ProductItem> productItemList1 = populateProductItem(productsList1,prices,quantitys);
    	
    	generateReceipt(productItemList1,1);
    	
    	//Output 2
    	String[] products2 = new String[] {"imported box of chocolates","imported bottle of perfume"}; 
    	BigDecimal[] prices2 = new BigDecimal[] {new BigDecimal(10.00), new BigDecimal(47.50)};
    	int[] quantitys2 = new int[] {1,1};
    	
    	ArrayList<Product> productsList2 = createProducts(products2);
    	
    	ArrayList<ProductItem> productItemList2 = populateProductItem(productsList2,prices2,quantitys2);
    	
    	generateReceipt(productItemList2,2);
    	
    	
    	//Output 3
    	String[] products3 = new String[] {"imported bottle of perfume","bottle of perfume","packet of headache pills","imported box of chocolates"}; 
    	BigDecimal[] prices3 = new BigDecimal[] {new BigDecimal(27.99), new BigDecimal(18.99),new BigDecimal(9.75),new BigDecimal(11.25)};
    	int[] quantitys3 = new int[] {1,1,1,1};
    	
    	ArrayList<Product> productsList3 = createProducts(products3);
    	
    	ArrayList<ProductItem> productItemList3 = populateProductItem(productsList3,prices3,quantitys3);
    	
    	generateReceipt(productItemList3,3);
    	
    	
    }



	private static void generateReceipt(ArrayList<ProductItem> productItemList,int count) {
		Receipt rec = new Receipt();
		for (ProductItem productItem : productItemList) {
			rec.addItem(productItem);
		}
		System.out.println("Output " + count + ":");
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
	
	private static void printInputs() {
		System.out.println("Input 1:\n1 book at 12.49\r\n" + 
				"1 music CD at 14.99\r\n" + 
				"1 chocolate bar at 0.85\n");
		
		System.out.println("Input 2:\n1 imported box of chocolates at 10.00\r\n" + 
				"1 imported bottle of perfume at 47.50\n");
		
		System.out.println("Input 3:\n1 imported bottle of perfume at 27.99\r\n" + 
				"1 bottle of perfume at 18.99\r\n" + 
				"1 packet of headache pills at 9.75\r\n" + 
				"1 imported box of chocolates at 11.25\n");
		
	}
}
