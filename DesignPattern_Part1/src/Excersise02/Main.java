package Excersise02;

public class Main {
	public static void main(String[] args) {
	
		Product product1 = new Product("Laptop", 1000, new VATStrategy());
		System.out.println("Strategy - Total price with VAT: " + product1.calculateTotalPrice());

		product1.setTaxStrategy(new LuxuryTaxStrategy());
		System.out.println("Strategy - Total price with Luxury Tax: " + product1.calculateTotalPrice());

		ProductWithState product2 = new ProductWithState("Phone", 500);
		System.out.println("State - Total price with No Tax: " + product2.calculateTotalPrice());

		product2.setTaxState(new HighTaxState());
		System.out.println("State - Total price with High Tax: " + product2.calculateTotalPrice());

		ProductComponent basicProduct = new BasicProduct("Watch", 200);
		ProductComponent productWithVAT = new VATDecorator(basicProduct);
		ProductComponent productWithLuxuryTax = new LuxuryTaxDecorator(productWithVAT);

		System.out.println("Decorator - Description: " + productWithLuxuryTax.getDescription());
		System.out.println("Decorator - Total price: " + productWithLuxuryTax.getPrice());
	}
}